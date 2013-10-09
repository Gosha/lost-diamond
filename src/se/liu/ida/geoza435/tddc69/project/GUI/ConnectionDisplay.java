package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Point;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Position;

@SuppressWarnings("serial")
public class ConnectionDisplay extends JLabel implements Observer {
	Connection connection;

	public ConnectionDisplay(Connection c) {
		this.connection = c;
		this.setBounds(boundsSet(new Rectangle()));
		this.setSize(sizeSet());
		this.connection.getA().observe(this);
		this.connection.getB().observe(this);
	}

	public Rectangle boundsSet(Rectangle rv) {
		/*
		 * TODO: Better name
		 */
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();

		rv.setBounds(Math.min(a.getX(), b.getX()),
				Math.min(a.getY(), b.getY()),
				Math.abs(a.getX() - b.getX()),
				Math.abs(a.getY() - b.getY()));
		System.out.println(rv);
		return rv;
	}

	public Dimension sizeSet() {
		/*
		 * TODO: Better name
		 */
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();
		Dimension d = new Dimension(Math.abs(a.getX() - b.getX())
				+ MarkDisplay.SIZE,
				Math.abs(a.getY() - b.getY()) + MarkDisplay.SIZE);
		return d;
	}

	@Override
	public void paintComponent(Graphics g) {
		/*
		 * TODO: Clean up
		 */
		super.paintComponent(g);
		Graphics2D g2d = DrawingTools.setupGraphics(g);

		// TODO: Better names
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();

		// System.out.println(sizeSet());
		if (connection.getType() != ConnectionType.normal) {
			BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);
			g2d.setStroke(bs1);
		}
		int offset = MarkDisplay.SIZE / 2;

		if (DrawingTools.connectionFromBottom(a, b)) {
			// Connection: /
			g2d.drawLine(
					offset,
					this.sizeSet().height - offset,
					this.sizeSet().width - offset,
					offset);
		} else {
			// Connection: \
			g2d.drawLine(
					offset, offset,
					this.sizeSet().width - offset,
					this.sizeSet().height - offset);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		if (super.contains(x, y)) {
			int offset = MarkDisplay.SIZE / 2;

			Point P = new Point(x, y);
			Position a = connection.getA().getPosition();
			Position b = connection.getB().getPosition();

			Point A, B;
			if (DrawingTools.connectionFromBottom(a, b)) {
				A = new Point(offset, this.sizeSet().height - offset);
				B = new Point(this.sizeSet().width - offset, offset);
			} else {
				A = new Point(offset, offset);
				B = new Point(this.sizeSet().width - offset,
						this.sizeSet().height - offset);
			}

			return DrawingTools.pointToLineDistance(A, B, P) < 5;
		}
		return false;
	}

	@Override
	public void notifyChange(Observable observable) {
		this.setBounds(this.boundsSet(new Rectangle()));
		this.setSize(this.sizeSet());
		this.repaint();
	}

}

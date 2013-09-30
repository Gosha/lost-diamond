package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Position;

@SuppressWarnings("serial")
public class ConnectionDisplay extends JLabel {
	Connection connection;

	public ConnectionDisplay(Connection c) {
		this.connection = c;
		this.setBounds(boundsSet(new Rectangle()));
		this.setSize(sizeSet());
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

		System.out.println(sizeSet());

		BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs1);
		int offset = MarkDisplay.SIZE / 2;

		if (a.getX() > b.getX() && a.getY() < b.getY()
				|| a.getX() < b.getX() && a.getY() > b.getY()) {
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

}

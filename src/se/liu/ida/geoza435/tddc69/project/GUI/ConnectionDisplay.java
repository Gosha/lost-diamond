package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Point;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Position;

@SuppressWarnings("serial")
public class ConnectionDisplay extends JLabel implements Observer {
	Connection connection;

	public final static Color STANDARD_COLOR = new Color(10, 10, 10);
	public final static Color FLIGHT_COLOR = new Color(200, 20, 20);
	public final static Color BOAT_COLOR = new Color(20, 20, 200);

	public ConnectionDisplay(Connection c) {
		this.connection = c;
		this.setBounds(rectangleSize());
		this.setSize(dimensionSize());
		this.connection.getA().observe(this);
		this.connection.getB().observe(this);
	}

	public Rectangle rectangleSize() {

		Rectangle rectangle = new Rectangle();

		Position posa = connection.getA().getPosition();
		Position posb = connection.getB().getPosition();

		rectangle.setBounds(Math.min(posa.getX(), posb.getX()),
				Math.min(posa.getY(), posb.getY()),
				Math.abs(posa.getX() - posb.getX()),
				Math.abs(posa.getY() - posb.getY()));

		return rectangle;
	}

	public Dimension dimensionSize() {
		Position posa = connection.getA().getPosition();
		Position posb = connection.getB().getPosition();
		return new Dimension(Math.abs(posa.getX() - posb.getX())
				+ MarkDisplay.SIZE,
				Math.abs(posa.getY() - posb.getY()) + MarkDisplay.SIZE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = DrawingTools.setupGraphics(g);

		Position posa = connection.getA().getPosition();
		Position posb = connection.getB().getPosition();

		BasicStroke stroke;

		switch (connection.getType()) {
		case normal:
			stroke = new BasicStroke(3, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);
			g2d.setColor(STANDARD_COLOR);
			break;
		case flight:
			stroke = new BasicStroke(8, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);
			g2d.setColor(FLIGHT_COLOR);
			break;
		case boat:
			stroke = new BasicStroke(5, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);
			g2d.setColor(BOAT_COLOR);
			break;
		default:
			stroke = new BasicStroke(8, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_BEVEL);
		}

		g2d.setStroke(stroke);
		int offset = MarkDisplay.SIZE / 2;

		if (DrawingTools.connectionFromBottom(posa, posb)) {
			// Connection: /
			g2d.drawLine(
					offset,
					this.dimensionSize().height - offset,
					this.dimensionSize().width - offset,
					offset);
		} else {
			// Connection: \
			g2d.drawLine(
					offset, offset,
					this.dimensionSize().width - offset,
					this.dimensionSize().height - offset);
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
				A = new Point(offset, this.dimensionSize().height - offset);
				B = new Point(this.dimensionSize().width - offset, offset);
			} else {
				A = new Point(offset, offset);
				B = new Point(this.dimensionSize().width - offset,
						this.dimensionSize().height - offset);
			}

			return DrawingTools.pointToLineDistance(A, B, P) < 5;
		}
		return false;
	}

	@Override
	public void notifyChange(Observable observable) {
		this.setBounds(rectangleSize());
		this.setSize(dimensionSize());
		this.repaint();
	}

	public Connection getConnection() {
		return connection;
	}

}

package se.liu.ida.geoza435.tddc69.project.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Position;

/**
 * Displays a {@link Connection} based on ConnectionType and the Marks it
 * connects.
 * 
 * @see DrawingTools#isConnectionFromBottom
 */
@SuppressWarnings({ "serial", "JavaDoc" })
public class ConnectionDisplay extends JLabel implements Observer {
	Connection connection;

	public final static Color STANDARD_COLOR = new Color(10, 10, 10);
	public final static Color FLIGHT_COLOR = new Color(200, 20, 20);
	public final static Color BOAT_COLOR = new Color(20, 20, 200);

	public ConnectionDisplay(Connection connection) {
		this.connection = connection;
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

	/**
	 * Draws the connection based on {@link ConnectionType} and
	 * {@link DrawingTools#isConnectionFromBottom}
	 */
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

		if (DrawingTools.isConnectionFromBottom(posa, posb)) {
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

	/**
	 * Returns true is the mouse pointer is closer than 5 units to the
	 * connection
	 */
	@Override
	public boolean contains(int x, int y) {
		if (super.contains(x, y)) {
			int offset = MarkDisplay.SIZE / 2;

			Point mousePoint = new Point(x, y);
			Position pointa = connection.getA().getPosition();
			Position pointb = connection.getB().getPosition();

			Point pointA, pointB;
			if (DrawingTools.isConnectionFromBottom(pointa, pointb)) {
				pointA = new Point(offset, this.dimensionSize().height - offset);
				pointB = new Point(this.dimensionSize().width - offset, offset);
			} else {
				pointA = new Point(offset, offset);
				pointB = new Point(this.dimensionSize().width - offset,
						this.dimensionSize().height - offset);
			}

			return DrawingTools.pointToLineDistance(pointA, pointB, mousePoint) < 5;
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

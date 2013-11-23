package se.liu.ida.geoza435.tddc69.project.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

/**
 * Displays a Mark based on Type and Position
 */
public class MarkDisplay extends JLabel implements Observer {
	Mark mark;
	Rectangle bounds;

	/** Square size */
	public final static int SIZE = 40;

	/** Radius of a normal mark */
	public final static int NORMAL_RADIUS = 15;
	/** Radius of a boat mark */
	public final static int BOAT_RADIUS = 15;
	/** Radius of a city mark */
	public final static int CITY_RADIUS = 20;
	/** Radius of a start point mark */
	public final static int START_RADIUS = 20;
	/** Radius mark that maybe doesn't exist. */
	public final static int DEFAULT_RADIUS = 20;

	/** Black normal color */
	public final static Color NORMAL_COLOR = new Color(10, 10, 10);
	/** Blue boat color */
	public final static Color BOAT_COLOR = new Color(20, 20, 200);
	/** Red city color */
	public final static Color CITY_COLOR = new Color(200, 20, 20);
	/** Green start color */
	public final static Color START_COLOR = new Color(20, 200, 20);
	/** Black ring color */
	public final static Color RING_COLOR = new Color(10, 10, 10);
	/** Yellow select color */
	public final static Color SELECT_COLOR = new Color(200, 200, 0);
	/** Black, used in case an uknown mark is drawn */
	public final static Color DEFAULT_COLOR = new Color(0, 0, 0);

	public MarkDisplay(Mark mark) {
		this.mark = mark;
		this.bounds = new Rectangle(
				mark.getPosition().getX(),
				mark.getPosition().getY(),
				SIZE, SIZE);
		this.setText(mark.toString());
		this.setBounds(bounds);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = DrawingTools.setupGraphics(g);

		Integer radius = DEFAULT_RADIUS;
		switch (mark.getType()) {
		case normal:
			radius = NORMAL_RADIUS;
			g2d.setColor(NORMAL_COLOR);
			break;
		case boat:
			radius = BOAT_RADIUS;
			g2d.setColor(BOAT_COLOR);
			break;
		case city:
			radius = CITY_RADIUS;
			g2d.setColor(RING_COLOR);
			g2d.fillOval((SIZE / 2) - radius,
					(SIZE / 2) - radius,
					2 * radius, 2 * radius);
			radius = CITY_RADIUS - 2;
			g2d.setColor(CITY_COLOR);
			break;
		case start:
			radius = START_RADIUS;
			g2d.setColor(START_COLOR);
			break;
		default:
			g2d.setColor(DEFAULT_COLOR);
			break;
		}

		g2d.fillOval((SIZE / 2) - radius,
				(SIZE / 2) - radius,
				2 * radius, 2 * radius);

		if (mark.isSelected()) {
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(SELECT_COLOR);
			g2d.drawOval(0, 0, SIZE, SIZE);
		}
	}

	@Override
	public void notifyChange(Observable observable) {
		this.repaint();
	}

	public Mark getMark() {
		return mark;
	}

}

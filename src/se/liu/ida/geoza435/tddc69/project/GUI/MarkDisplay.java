package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

@SuppressWarnings("serial")
public class MarkDisplay extends JLabel implements Observer {
	public Mark mark;
	Rectangle bounds;
	public Point anchorPoint;
	public boolean overbearing;

	public final static int SIZE = 40;

	public MarkDisplay(Mark mark) {
		this.mark = mark;
		this.bounds = new Rectangle(
				mark.getPosition().getX(),
				mark.getPosition().getY(),
				SIZE, SIZE);
		this.setText(mark.toString());
		this.setBounds(bounds);
		this.setForeground(Color.BLUE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = DrawingTools.setupGraphics(g);
		// TODO Color constants, ugh

		Integer radius = 20;
		switch (mark.getType()) {
		case normal:
			radius = 15;
			g2d.setColor(new Color(10, 10, 10, 255));
			break;
		case boat:
			radius = 15;
			g2d.setColor(new Color(20, 20, 200));
			break;
		case city:
			radius = 20;
			g2d.setColor(new Color(10, 10, 10));
			g2d.fillOval((SIZE / 2) - radius, (SIZE / 2) - radius,
					2 * radius, 2 * radius);
			radius = 18;
			g2d.setColor(new Color(200, 20, 20));
			break;
		case start:
			radius = 20;
			g2d.setColor(new Color(200, 200, 20));
			break;
		default:
			g2d.setColor(new Color(0, 0, 0, 255));
			break;
		}

		g2d.fillOval((SIZE / 2) - radius, (SIZE / 2) - radius,
				2 * radius, 2 * radius);

		if (mark.isSelected()) {
			g2d.setStroke(new BasicStroke(3));
			g2d.setColor(new Color(200, 200, 0, 255));
			g2d.drawOval(0, 0, SIZE, SIZE);
		}
		// Paint Label text / Other super stuff
		// super.paintComponent(g);
	}

	@Override
	public void notifyChange(Observable observable) {
		this.repaint();
	}

}

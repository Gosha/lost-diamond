package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.game.Mark;

public class MarkDisplay extends JLabel {
	Mark mark;
	Rectangle bounds;

	public MarkDisplay(Mark mark) {
		this.mark = mark;
		this.bounds = new Rectangle(
				mark.getPosition().getX(),
				mark.getPosition().getY(),
				150, 40);
		this.setText(mark.toString());
		this.setBounds(bounds);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = DrawingTools.setupGraphics(g);
		//TODO Constants?
		g2d.setColor(new Color(200, 0, 0));
		g2d.fillOval(0, 0, 40, 40);
	}
}

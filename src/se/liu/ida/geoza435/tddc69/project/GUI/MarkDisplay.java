package se.liu.ida.geoza435.tddc69.project.GUI;

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
				150, 20);
		this.setText(mark.toString());
		this.setBounds(bounds);
	}
}

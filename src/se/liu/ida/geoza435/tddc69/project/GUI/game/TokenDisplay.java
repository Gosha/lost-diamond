package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.GUI.DrawingTools;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Position;
import se.liu.ida.geoza435.tddc69.project.game.Token;

@SuppressWarnings("serial")
public class TokenDisplay extends JLabel {

	public static final int MARGIN = 5;
	public static final Color COLOR = new Color(255, 255, 255);

	@SuppressWarnings("ObjectToString")
	public TokenDisplay(Token token) {
		// TODO Finish TokenDisplay
		super(token.getGameComponent().getClass().getCanonicalName()
				.split("\\.")[7]);

		Position position = token.getAt().getPosition();
		this.setBounds(0, 0, 100, 50);
		this.setLocation(position.getX(), position.getY());
	}

	@Override
	public boolean contains(int x, int y) {
		return false;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics2D g2d = DrawingTools.setupGraphics(graphics);

		g2d.setColor(new Color(200, 200, 200));

		int size = MarkDisplay.SIZE - MARGIN * 2;
		g2d.fillRect(MARGIN, MARGIN, size, size);

		super.paintComponent(graphics);
	}

}

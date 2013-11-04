package se.liu.ida.geoza435.tddc69.project.gui.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Position;
import se.liu.ida.geoza435.tddc69.project.game.Token;
import se.liu.ida.geoza435.tddc69.project.gui.DrawingTools;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;

/**
 * Displays a Token based on the Mark it is located at.
 * 
 * If the Mark it is located at is null, it removes itself.
 */
@SuppressWarnings({ "serial", "JavaDoc" })
public class TokenDisplay extends JLabel implements Observer {

	public static final int MARGIN = 5;
	public static final Color COLOR = new Color(255, 255, 255);

	public TokenDisplay(Token token) {
		Position position = token.getAt().getPosition();
		this.setBounds(0, 0, 100, 50);
		this.setLocation(position.getX(), position.getY());

		token.observe(this);
	}

	@SuppressWarnings("RefusedBequest")
	@Override
	public boolean contains(int x, int y) {
		return false;
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		Graphics2D g2d = DrawingTools.setupGraphics(graphics);

		g2d.setColor(COLOR);

		int size = MarkDisplay.SIZE - MARGIN * 2;
		g2d.fillRect(MARGIN, MARGIN, size, size);

		super.paintComponent(graphics);
	}

	@Override
	public void notifyChange(Observable observable) {
		if (observable instanceof Token) {
			Token token = (Token) observable;
			if (token.getAt() == null) {
				this.getParent().remove(this);
			}
		}
	}
}

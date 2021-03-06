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
public class TokenDisplay extends JLabel implements Observer {

	/** How much less that a MarkDisplay a token is */
	public static final int MARGIN = 5;
	/** White token color */
	public static final Color COLOR = new Color(255, 255, 255);

	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;

	public TokenDisplay(Token token) {
		Position position = token.getAt().getPosition();
		this.setBounds(0, 0, WIDTH, HEIGHT);
		this.setLocation(position.getX(), position.getY());

		token.observe(this);
	}

	// Yes, it ignores the super method because that's the point.
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

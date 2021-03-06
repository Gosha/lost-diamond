package se.liu.ida.geoza435.tddc69.project.gui.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Debug;
import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Position;
import se.liu.ida.geoza435.tddc69.project.gui.DrawingTools;

/**
 * Displays a player based on a random color and the Position of the Mark the
 * Player is standing on.
 */
public class PlayerDisplay extends JLabel implements Observer {

	Player player;
	/** Height of a player */
	public final static int HEIGHT = 50;
	/** Width of a player */
	public final static int WIDTH = 40;
	/** Offset for the players location on a mark */
	public final static int Y_OFFSET = 25;

	/** Diameter of a player token head */
	final static int HEAD_SIZE = 25;
	/** Offset the upper end of the player token lower polygon */
	public final static int NECK_OFFSET = 17;

	Color color;

	final static int MAX_RANDOM_COLOR = 200;

	public PlayerDisplay(Player player) {
		this.player = player;
		player.observe(this);
		Rectangle bounds = new Rectangle(
				player.getAt().getPosition().getX(),
				player.getAt().getPosition().getY() - Y_OFFSET,
				WIDTH, HEIGHT);
		this.setText(player.toString());
		this.setBounds(bounds);
		this.color = new Color((int) (Math.random() * MAX_RANDOM_COLOR),
				(int) (Math.random() * MAX_RANDOM_COLOR),
				(int) (Math.random() * MAX_RANDOM_COLOR));

		Debug.out("New Player: " + player);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = DrawingTools.setupGraphics(g);
		g2d.setColor(color);
		// I am aware that these are magic numbers, but so is drawing.
		g2d.fillOval(5, 0, HEAD_SIZE, HEAD_SIZE);
		Polygon p = new Polygon();
		p.addPoint(NECK_OFFSET, 10);
		p.addPoint(5, HEIGHT);
		p.addPoint(WIDTH - 5, HEIGHT);
		p.addPoint(WIDTH - NECK_OFFSET, 10);
		g2d.fillPolygon(p);
	}

	// Update the GUI position when the Player moves.
	@Override
	public void notifyChange(Observable observable) {
		Position markPosition = player.getAt().getPosition();
		setLocation(new Point(markPosition.getX(),
				markPosition.getY() - Y_OFFSET));
		this.repaint();
	}
}

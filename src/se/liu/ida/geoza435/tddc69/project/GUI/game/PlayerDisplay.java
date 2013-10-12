package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.GUI.DrawingTools;
import se.liu.ida.geoza435.tddc69.project.game.Debug;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Position;

@SuppressWarnings("serial")
public class PlayerDisplay extends JLabel implements Observer {

	Player player;
	public final static int SIZE = 40;
	public final static int HEIGHT = 50;
	public final static int WIDTH = 40;
	public final static int Y_OFFSET = 25;
	public Color color;

	public PlayerDisplay(Player player) {
		this.player = player;
		player.observe(this);
		Rectangle bounds = new Rectangle(
				player.getAt().getPosition().getX(),
				player.getAt().getPosition().getY() - Y_OFFSET,
				WIDTH, HEIGHT);
		this.setText(player.toString());
		this.setBounds(bounds);
		this.color = new Color((int) (Math.random() * 200),
				(int) (Math.random() * 200),
				(int) (Math.random() * 200));
		Debug.o("New Player: " + player);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		Graphics2D g2d = DrawingTools.setupGraphics(arg0);
		g2d.setColor(color);
		g2d.fillOval(5, 0, 30, 30);
		Polygon p = new Polygon();
		p.addPoint(17, 10);
		p.addPoint(5, HEIGHT);
		p.addPoint(WIDTH - 5, HEIGHT);
		p.addPoint(WIDTH - 17, 10);
		g2d.fillPolygon(p);
	}

	@Override
	public void notifyChange(Observable observable) {
		Position markPosition = player.getAt().getPosition();
		setLocation(new Point(markPosition.getX(),
				markPosition.getY() - Y_OFFSET));
		this.repaint();
	}
}

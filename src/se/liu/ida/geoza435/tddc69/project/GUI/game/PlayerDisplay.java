package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Debug;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Position;

@SuppressWarnings("serial")
public class PlayerDisplay extends JLabel implements Observer {

	Player player;
	public final static int SIZE = 40;

	public PlayerDisplay(Player player) {
		this.player = player;
		player.observe(this);
		Rectangle bounds = new Rectangle(
				player.getAt().getPosition().getX(),
				player.getAt().getPosition().getY(),
				SIZE + 100, SIZE);
		this.setText(player.toString());
		this.setBounds(bounds);
		Debug.o("New Player: " + player);
	}

	@Override
	public void notifyChange(Observable observable) {
		Position markPosition = player.getAt().getPosition();
		setLocation(new Point(markPosition.getX(), markPosition.getY()));
		this.repaint();
	}
}

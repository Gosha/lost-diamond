package se.liu.ida.geoza435.tddc69.project.GUI.game;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Player;

@SuppressWarnings("serial")
public class PlayerDisplay extends JLabel implements Observer {

	Player player;

	public PlayerDisplay(Player player) {
		this.player = player;
		player.observe(this);
	}

	@Override
	public void notifyChange(Observable observable) {
		this.repaint();
	}
}

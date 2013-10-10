package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Player;

@SuppressWarnings("serial")
public class BoardGameDisplay extends BoardDisplay {

	List<PlayerDisplay> playersDisplays = new ArrayList<PlayerDisplay>();

	public BoardGameDisplay(Board board) {
		super(board);
	}

	public PlayerDisplay addPlayerDisplay(Player player) {
		PlayerDisplay newPlayerDisplay = new PlayerDisplay(player);
		playersDisplays.add(newPlayerDisplay);
		add(newPlayerDisplay);
		setComponentZOrder(newPlayerDisplay, 0);
		return newPlayerDisplay;
	}

}

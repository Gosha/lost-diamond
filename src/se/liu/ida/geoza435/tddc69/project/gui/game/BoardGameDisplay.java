package se.liu.ida.geoza435.tddc69.project.gui.game;

import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;
import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;

/**
 * Contains {@link PlayerDisplay}s and {@link TokenDisplay}s
 * 
 * @see BoardDisplay
 */
public class BoardGameDisplay extends BoardDisplay {

	List<PlayerDisplay> playerDisplays = new ArrayList<>();
	List<TokenDisplay> tokenDisplays = new ArrayList<>();

	public BoardGameDisplay(Board board) {
		super(board);
	}

	public void addPlayerDisplay(Player player) {
		PlayerDisplay newPlayerDisplay = new PlayerDisplay(player);
		playerDisplays.add(newPlayerDisplay);
		add(newPlayerDisplay);
		setComponentZOrder(newPlayerDisplay, 0);
	}

	public void addTokenDisplay(Token token) {
		TokenDisplay newTokenDisplay = new TokenDisplay(token);
		tokenDisplays.add(newTokenDisplay);
		add(newTokenDisplay);
		setComponentZOrder(newTokenDisplay, 0);
	}

}

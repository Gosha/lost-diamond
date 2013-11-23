package se.liu.ida.geoza435.tddc69.project.gui.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

/**
 * Sets up the GameView.
 * 
 * A boardGameDisplay spans the whole frame in a JScrollPane. Status of the
 * players is showed in separate JPanel on the Glass Pane
 * 
 */
public class GameView extends JFrame {

	private BoardGameDisplay boardGameDisplay;
	private Game game;

	private static final int WIDTH = 600;
	private static final int HEIGHT = 500;

	final static int SCROLL_INCREMENT = 16;

	public GameView(Game game) {
		this.game = game;
		this.boardGameDisplay = new BoardGameDisplay(game.getBoard());
	}

	public void initUI() {
		JScrollPane spane = new JScrollPane();

		spane.setViewportView(boardGameDisplay);
		spane.getVerticalScrollBar().setUnitIncrement(SCROLL_INCREMENT);

		add(spane, BorderLayout.CENTER);

		StatusDisplay status = new StatusDisplay(game);
		setGlassPane(status);
		status.setVisible(true);

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void loadGame() {
		for (Token token : game.getTokens()) {
			boardGameDisplay.addTokenDisplay(token);
		}

		for (Player p : game.getPlayers()) {
			boardGameDisplay.addPlayerDisplay(p);
		}
	}

	public BoardGameDisplay getBoardGameDisplay() {
		return boardGameDisplay;
	}

}

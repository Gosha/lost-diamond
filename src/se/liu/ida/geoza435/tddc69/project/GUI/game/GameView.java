package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import se.liu.ida.geoza435.tddc69.project.game.Game;

@SuppressWarnings("serial")
public class GameView extends JFrame {

	// TODO Public variables
	BoardGameDisplay boardGameDisplay;
	Game game;

	public GameView(Game game) {
		this.game = game;
		this.boardGameDisplay = new BoardGameDisplay(game.getBoard());
	}

	public void initUI() {
		JScrollPane spane = new JScrollPane();

		spane.setViewportView(boardGameDisplay);
		// noinspection MagicNumber
		spane.getVerticalScrollBar().setUnitIncrement(16);

		add(spane, BorderLayout.CENTER);

		StatusDisplay status = new StatusDisplay(game);
		setGlassPane(status);
		status.setVisible(true);

		// TODO: Constants
		// noinspection MagicNumber
		setSize(600, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}

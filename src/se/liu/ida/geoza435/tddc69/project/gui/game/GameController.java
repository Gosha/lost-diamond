package se.liu.ida.geoza435.tddc69.project.gui.game;

import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;
import se.liu.ida.geoza435.tddc69.project.game.Token;

/**
 * Sets up a {@link Game} and a GUI (BoardGameDisplay).
 * 
 * Also fires up the actual game.
 */
public final class GameController {
	public GameController() throws Exception {
		final Game game = new Game();
		game.loadBoard("africa.dat");

		final GameView gameView = new GameView(game);

		final TextPlayer p1 = new TextPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0), game);
		final TextPlayer p3 = new TextPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0), game);
		final GUIPlayer p2 = new GUIPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0), gameView.boardGameDisplay, game);

		game.addPlayer(p1);
		// game.addPlayer(p2);
		game.addPlayer(p3);

		game.init();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				gameView.initUI();
				gameView.boardGameDisplay.loadBoard();

				// TODO Move to BoardGameDisplay/GameView
				for (Token token : game.getTokens()) {
					gameView.boardGameDisplay.addTokenDisplay(token);
				}

				// TODO Add to load
				gameView.boardGameDisplay.addPlayerDisplay(p1);
				// gameView.boardGameDisplay.addPlayerDisplay(p2);
				gameView.boardGameDisplay.addPlayerDisplay(p3);
			}

		});

		try {
			game.start();
		} catch (Exception e) {
			game.init();
			game.start();
		}

	}
}

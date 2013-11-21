package se.liu.ida.geoza435.tddc69.project.gui.game;

import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.GameNotInitializedException;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;

/**
 * Sets up a {@link Game} and a GUI (BoardGameDisplay).
 * 
 * Also fires up the actual game.
 */
public final class GameController {
	final GameView gameView;
	final Game game;

	public GameController() throws GameNotInitializedException {
		game = new Game();
		game.loadBoard("africa.dat");

		gameView = new GameView(game);

		final TextPlayer p1 = new TextPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0), game);
		final TextPlayer p3 = new TextPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0), game);
		final GUIPlayer p2 = new GUIPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0), gameView.getBoardGameDisplay(), game);

		game.addPlayer(p1);
		game.addPlayer(p2);
		game.addPlayer(p3);

		game.init();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				gameView.initUI();
				gameView.getBoardGameDisplay().loadBoard();

				gameView.loadGame();
			}

		});

		game.start();
	}
}

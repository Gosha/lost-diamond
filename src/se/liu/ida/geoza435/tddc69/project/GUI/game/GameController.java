package se.liu.ida.geoza435.tddc69.project.GUI.game;

import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;
import se.liu.ida.geoza435.tddc69.project.game.Token;

public class GameController {
	public static void main(String[] args) throws Exception {
		final Game game = new Game();
		game.loadBoard("africa.dat");

		final GameView gameView = new GameView(game);

		final TextPlayer p1 = new TextPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0));
		final GUIPlayer p2 = new GUIPlayer(game.getBoard().getMarksOfType(
				MarkType.start).get(0), gameView.boardGameDisplay);

		game.addPlayer(p1);
		game.addPlayer(p2);

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

				gameView.boardGameDisplay.addPlayerDisplay(p1);
				gameView.boardGameDisplay.addPlayerDisplay(p2);
			}

		});

		game.main();

	}
}

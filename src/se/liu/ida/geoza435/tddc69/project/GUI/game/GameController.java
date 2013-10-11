package se.liu.ida.geoza435.tddc69.project.GUI.game;

import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;

public class GameController {
	public static void main(String[] args) throws InterruptedException {
		final Game game = new Game();
		game.loadBoard("/home/gosha/board2.dat");

		final GameView gameView = new GameView(game);

		final TextPlayer p1 = new TextPlayer(game.getMarksOfType(
				MarkType.start).get(0));
		final GUIPlayer p2 = new GUIPlayer(game.getMarksOfType(
				MarkType.start).get(0), gameView.boardGameDisplay);

		// game.addPlayer(p1);
		game.addPlayer(p2);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				gameView.initUI();
				gameView.boardGameDisplay.loadBoard();

				gameView.boardGameDisplay.addPlayerDisplay(p1);
				gameView.boardGameDisplay.addPlayerDisplay(p2);
			}

		});

		game.main();

	}
}
package se.liu.ida.geoza435.tddc69.project.GUI.game;

import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;

public class GameController {
	public static void main(String[] args) {
		final Game game = new Game();
		game.loadBoard("/home/gosha/small.dat");

		final GameView gameView = new GameView(game);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				gameView.initUI();
				gameView.boardGameDisplay.loadBoard();
				TextPlayer p1 = new TextPlayer(game.getMarksOfType(
						MarkType.start).get(0));
				game.addPlayer(p1);
				gameView.boardGameDisplay.addPlayerDisplay(p1);
			}

		});
	}
}

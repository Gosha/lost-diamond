package se.liu.ida.geoza435.tddc69.project;

import se.liu.ida.geoza435.tddc69.project.game.Debug;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;

/**
 * Simple CLI, non-interactive test of the Game
 */
public final class GameTest {
	private GameTest() {}

	public static void main(String[] args) throws Exception {
		Game game = new Game();
		game.loadBoard("africa.dat");
		Player p1 = new TextPlayer(game.getBoard()
				.getMarksOfType(MarkType.start).get(0), game);
		game.addPlayer(p1);
		game.init();
		// o(p1.toString());
		// for(Mark m : p1.getAt().getNextMarks(2))
		// o(m.toString());
		Debug.o("Start");
		game.start();
	}

}

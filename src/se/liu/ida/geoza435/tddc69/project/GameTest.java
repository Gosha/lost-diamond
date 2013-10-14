package se.liu.ida.geoza435.tddc69.project;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;

public final class GameTest {
	private GameTest() {}

	public static void main(String[] args) throws Exception {
		Game game = new Game();
		game.loadBoard("/home/gosha/small.dat");
		Player p1 = new TextPlayer(game.getBoard()
				.getMarksOfType(MarkType.start).get(0));
		game.addPlayer(p1);
		game.init();
		// o(p1.toString());
		// for(Mark m : p1.getAt().getNextMarks(2))
		// o(m.toString());
		// game.main();
		o("Start");
		game.main();
	}

	private static void o(String str) {
		System.out.println(str);
	}
}

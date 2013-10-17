package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Gives a Player a standard movement choice. A list of MarkListContainer is
 * given to the Player.
 * 
 * @see StandardMovement
 */
public class MovementChoice implements Choice {

	Mark to = null;
	Game game;

	public MovementChoice(Game game) {
		this.game = game;
	}

	@Override
	public void execute(Player player) {
		player.move(to);
		player.hasMoved = true;
	}

	@Override
	public void choose(Player player) {

		int die = game.rollDie();

		ArrayList<MarkListContainer> marks = player.getAt().getNextMarks(die,
				ConnectionType.normal);
		Iterator<MarkListContainer> iterator = marks.iterator();

		while (iterator.hasNext()) {
			MarkListContainer mlc = iterator.next();
			if (mlc.getDistance() != die
					&& mlc.getMark().getType() != MarkType.city) {
				iterator.remove();
			}
		}

		Debug.o(marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Move";
	}

}

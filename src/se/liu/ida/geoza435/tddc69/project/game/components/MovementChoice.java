package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.ArrayList;
import java.util.Iterator;

import se.liu.ida.geoza435.tddc69.project.Debug;
import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkListContainer;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;

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
		player.setHasMoved(true);
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

		Debug.o("Can move to: " + marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Move";
	}

}

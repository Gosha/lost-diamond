package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Debug;
import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkListContainer;
import se.liu.ida.geoza435.tddc69.project.game.Player;

/**
 * Presents choices of Marks the player can fly to.
 */
public class FlightChoice implements Choice {

	Mark to = null;

	@Override
	public void execute(Player player) {
		player.move(to);
		// noinspection MagicNumber
		player.takeMoney(3000);
		player.setHasMoved(true);
	}

	@Override
	public void choose(Player player) {

		List<MarkListContainer> marks = player.getAt().getNextMarks(1,
				ConnectionType.flight);

		Debug.out("Can fly to: " + marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Fly";
	}

}

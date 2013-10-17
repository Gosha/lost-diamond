package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

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
		player.hasMoved = true;
	}

	@Override
	public void choose(Player player) {

		List<MarkListContainer> marks = player.getAt().getNextMarks(1,
				ConnectionType.flight);

		Debug.o("Can fly to: " + marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Fly";
	}

}

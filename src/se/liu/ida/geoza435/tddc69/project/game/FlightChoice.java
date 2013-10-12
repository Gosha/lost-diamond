package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;

public class FlightChoice extends Choice {

	Mark to;

	public FlightChoice(Game game) {
		super(game);
	}

	@Override
	public void execute(Player player) {
		player.move(to);
	}

	@Override
	public void choose(Player player) {

		ArrayList<MarkListContainer> marks = player.getAt().getNextMarks(1,
				ConnectionType.flight);

		Debug.o(marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Flight";
	}

}

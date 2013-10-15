package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

public class FlightChoice extends Choice {

	Mark to = null;

	public FlightChoice(Game game) {
		super(game);
	}

	@Override
	public void execute(Player player) {
		player.move(to);
		player.takeMoney(3000);
	}

	@Override
	public void choose(Player player) {

		List<MarkListContainer> marks = player.getAt().getNextMarks(1,
				ConnectionType.flight);

		Debug.o(marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Fly";
	}

}

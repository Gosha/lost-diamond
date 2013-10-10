package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.Iterator;

public class MovementChoice extends Choice {

	Mark to;

	public MovementChoice(Game game) {
		super(game);
	}

	@Override
	public void execute(Player player) {
		player.move(to);
	}

	@Override
	public void choose(Player player) {

		int die = game.rollDie();

		Debug.o(die);

		ArrayList<MarkListContainer> marks = player.getAt().getNextMarks(die);
		Iterator<MarkListContainer> iterator = marks.iterator();
		MarkListContainer mlc;

		while (iterator.hasNext()) {
			mlc = iterator.next();
			if (mlc.getMark().getType() != MarkType.normal
					&& mlc.getMark().getType() != MarkType.city
					&& mlc.getMark().getType() != MarkType.start) {
				iterator.remove();
			} else if (mlc.getDistance() != die) {
				iterator.remove();
			}
		}

		Debug.o(marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Standard movement";
	}

}

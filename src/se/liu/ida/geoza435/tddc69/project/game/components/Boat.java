package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Debug;
import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkListContainer;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;

public class Boat extends GameComponent implements Choice {

	DoNothing doNothing;
	Mark to = null;
	boolean isFree;
	public final static int COST = 1000;

	public Boat(Game game, DoNothing doNothing) {
		super(game);
		this.doNothing = doNothing;
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		super.addChoices(player, choices);
		if (player.isNextTo(ConnectionType.boat)) {
			if (player.lastChoice() == doNothing
					|| (player.lastChoice() == this
					&& player.getAt().getType() == MarkType.boat)) {
				isFree = true;
			} else {
				isFree = false;
			}
			if (isFree || player.hasAtLeast(COST))
				choices.add(this);
		}
	}

	@Override
	public void execute(Player player) {
		player.move(to);
		if (!isFree) {
			// noinspection MagicNumber
			player.takeMoney(COST);
		}
		player.setHasMoved(true);
	}

	@Override
	public void choose(Player player) {

		int die = game.rollDie();

		List<MarkListContainer> marks = player.getAt().getNextMarks(die,
				ConnectionType.boat);

		// TODO Filter out marks

		Debug.o("Can go by boat to to: " + marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Go by boat";
	}

}
package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Debug;
import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkListContainer;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;

/**
 * Defines logic for how a player can move through ConnectionType.Boat.
 * 
 * A special rule is that if a player did nothing last turn he is allowed to go
 * by boat for free.
 */

public class Boat extends GameComponent implements Choice {

	DoNothing doNothing;
	Mark to = null;
	boolean isFree;
	/** The cost of a boat trip */
	public final static int COST = 1000;

	public Boat(Game game, DoNothing doNothing) {
		super(game);
		this.doNothing = doNothing;
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		super.addChoices(player, choices);
		if (player.isNextTo(ConnectionType.boat)) {
			if (player.lastChoice() != null
			    && (player.lastChoice().equals(doNothing)
					|| (player.lastChoice().equals(this)
					&& player.getAt().getType().equals(MarkType.boat)))) {
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
			player.takeMoney(COST);
		}
		player.setHasMoved(true);
	}

	@Override
	public void choose(Player player) {

		int die = game.rollDie();

		List<MarkListContainer> marks = player.getAt().getNextMarks(die,
				ConnectionType.boat);

		// Not implemented: Filter out marks

		Debug.out("Can go by boat to to: " + marks);

		to = player.chooseMark(marks);
	}

	@Override
	public String toString() {
		return "Go by boat";
	}

}

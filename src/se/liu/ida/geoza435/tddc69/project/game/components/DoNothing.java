package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Debug;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;

/**
 * Under some circumstances a player can chose to do nothing;
 * <ul>
 * <li>When player stands on a City</li>
 * <li>When player has moved</li>
 * </ul>
 */
public class DoNothing extends GameComponent implements Choice {

	public DoNothing(Game game) {
		super(game);
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		super.addChoices(player, choices);
		if (player.isOn(MarkType.city))
			choices.add(this);
	}

	@Override
	public void addPostMoveChoices(Player player, List<Choice> choices) {
		super.addPostMoveChoices(player, choices);
		this.addChoices(player, choices);
	}

	@Override
	public void choose(Player player) {
		// simply nothing
		Debug.out("Chose to do nothing");
	}

	@Override
	public void execute(Player player) {
		// simply nothing
	}

	@Override
	public String toString() {
		return "Do nothing";
	}

}

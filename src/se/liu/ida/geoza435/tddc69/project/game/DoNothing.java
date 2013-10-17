package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

/**
 * Under some circumstances a player can chose to do nothing;
 * <ul>
 * <li>When player stands on a City</li>
 * <li>When player has moved</li>
 * </ul>
 */
@SuppressWarnings("RefusedBequest")
public class DoNothing extends GameComponent implements Choice {

	DoNothing(Game game) {
		super(game);
	}

	@Override
	void addChoices(Player player, List<Choice> choices) {
		if (player.isOn(MarkType.city))
			choices.add(this);
	}

	@Override
	public void addPostMoveChoices(Player player, List<Choice> choices) {
		this.addChoices(player, choices);
	}

	@Override
	public void choose(Player player) {
		// simply nothing
		Debug.o("Chose to do nothing");
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

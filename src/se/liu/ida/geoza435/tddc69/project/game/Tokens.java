package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

/**
 * When a player stands on a token or has just moved to a Token he can chose to
 * flip it.
 */
@SuppressWarnings("RefusedBequest")
public class Tokens extends GameComponent {

	Tokens(Game game) {
		super(game);
	}

	@Override
	void addChoices(Player player, List<Choice> choices) {
		if (player.standsOnToken())
			choices.add(new FlipChoice(game));
	}

	@Override
	public void addPostMoveChoices(Player player, List<Choice> choices) {
		addChoices(player, choices);
	}

}

package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;

/**
 * When a player stands on a token or has just moved to a Token he can chose to
 * flip it.
 */
@SuppressWarnings("RefusedBequest")
public class Tokens extends GameComponent {

	public Tokens(Game game) {
		super(game);
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		if (player.standsOnToken())
			choices.add(new FlipChoice(game));
	}

	@Override
	public void addPostMoveChoices(Player player, List<Choice> choices) {
		addChoices(player, choices);
	}

}

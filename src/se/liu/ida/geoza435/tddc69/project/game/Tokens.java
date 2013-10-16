package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

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
		if (player.standsOnToken())
			choices.add(new FlipChoice(game));
	}

}

package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

/**
 * A player can always chose to do a standard movement.
 */
@SuppressWarnings("RefusedBequest")
public class StandardMovement extends GameComponent {

	public StandardMovement(Game game) {
		super(game);
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		choices.add(new MovementChoice(game));
	}

}

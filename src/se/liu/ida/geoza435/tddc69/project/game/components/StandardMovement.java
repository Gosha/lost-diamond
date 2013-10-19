package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;

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
		if (player.isNextTo(ConnectionType.normal))
			choices.add(new MovementChoice(game));
	}

}

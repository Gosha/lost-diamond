package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;

/**
 * A player can chose to Fly if he is standing on a city, there is a flight
 * connection and he has at least 3000 money.
 */
public class Flight extends GameComponent {

	public Flight(Game game) {
		super(game);
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		// noinspection MagicNumber
		if (player.isOn(MarkType.city, MarkType.start)
				&& player.isNextTo(ConnectionType.flight)
				&& player.hasAtLeast(3000))
			choices.add(new FlightChoice());
	}

}

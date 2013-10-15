package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

public class Flight extends GameComponent {

	public Flight(Game game) {
		super(game);
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		if (player.isOn(MarkType.city, MarkType.start)
				&& player.isNextTo(ConnectionType.flight))
			choices.add(new FlightChoice(game));
	}

}

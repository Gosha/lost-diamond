package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

public class Flight extends GameComponent {

	public Flight(Game game) {
		super(game);
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		if ((player.at.getType() == MarkType.city
				|| player.at.getType() == MarkType.start)
				&& !player.at.getNextMarks(1, ConnectionType.flight).isEmpty())
			choices.add(new FlightChoice(game));
	}

}

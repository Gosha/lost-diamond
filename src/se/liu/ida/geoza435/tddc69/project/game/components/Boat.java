package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;

public class Boat extends GameComponent {

	DoNothing doNothing;

	public Boat(Game game, DoNothing doNothing) {
		super(game);
		this.doNothing = doNothing;
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		super.addChoices(player, choices);
		if (player.isNextTo(ConnectionType.boat)) {
			if (player.lastChoice() == doNothing) {
				choices.add(new BoatChoice(game, true));
			} else {
				choices.add(new BoatChoice(game, false));
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

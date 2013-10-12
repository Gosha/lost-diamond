package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

public class StandardMovement extends GameComponent {

	public StandardMovement(Game game) {
		super(game);
	}

	@Override
	public void init(Game game) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		choices.add(new MovementChoice(game));
	}

}

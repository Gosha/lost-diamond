package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;

abstract class GameComponent {

	Game game;

	public GameComponent(Game game) {
		this.game = game;
	}

	public abstract void init(Game game);

	public void visit(Token token, Player player) {
	}

	public void addChoices(Player player, ArrayList<Choice> choices) {
	}

}

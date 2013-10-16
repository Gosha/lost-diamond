package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

@SuppressWarnings("NoopMethodInAbstractClass")
public abstract class GameComponent {

	Game game;

	GameComponent(Game game) {
		this.game = game;
	}

	void init() {}

	void visit(Token token, Player player) {}

	void addChoices(Player player, List<Choice> choices) {}

	public void addPostMoveChoices(Player player, List<Choice> choices) {}

	public void postTurn(Player player) {}

}

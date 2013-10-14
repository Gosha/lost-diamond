package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

@SuppressWarnings("NoopMethodInAbstractClass")
abstract class GameComponent {

	Game game;

	GameComponent(Game game) {
		this.game = game;
	}

	void init(Game game) {}

	void visit(Token token, Player player) {}

	void addChoices(Player player, List<Choice> choices) {}

}

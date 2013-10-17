package se.liu.ida.geoza435.tddc69.project.game;

import java.util.List;

/**
 * All game rules are subclasses of GameComponent.
 * 
 * Rules do many different things, therefore there are many Null-methods a
 * GameComponent may chose not to implement.
 * 
 * For instance, the rules for {@link Flight} has no initialization to do and
 * therefore doesn't override init(). However, AfricasStar has to use the init()
 * to put a token on the board, but doesn't give any additional choices.
 */
@SuppressWarnings({ "NoopMethodInAbstractClass",
		"AbstractClassWithoutAbstractMethods" })
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

	@Override
	public String toString() {
		return this.getClass().toString();
	}

}

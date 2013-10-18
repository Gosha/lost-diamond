package se.liu.ida.geoza435.tddc69.project.game.components;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

public class Black extends GameComponent {

	private Tokens tokens;

	public Black(Game game, Tokens tokens) {
		super(game);
		this.tokens = tokens;
	}

	@Override
	public void init() {
		super.init();
		// 20 because there are supposed to be 6 in the original game.
		tokens.addPercentally(this, 20);
	}

	@Override
	public void visit(Token token, Player player) {
		super.visit(token, player);
		tokens.removeToken(token);
		// Nothing
	}

}

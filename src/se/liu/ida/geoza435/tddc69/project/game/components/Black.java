package se.liu.ida.geoza435.tddc69.project.game.components;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

/**
 * Handles logic for what happens when one flips a Black token, which is
 * nothing, the token just dissappears.
 */
public class Black extends GameComponent {

	private Tokens tokens;

	public Black(Game game, Tokens tokens) {
		super(game);
		this.tokens = tokens;
	}

	@Override
	public void init() {
		super.init();
		tokens.addNumOfTokens(this, 6);
	}

	@Override
	public void visit(Token token, Player player) {
		super.visit(token, player);
		tokens.removeToken(token);
		// Nothing
	}

}

package se.liu.ida.geoza435.tddc69.project.game.components;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

/**
 * Defines logic for what happens when a player flips a Token with a robber on
 * it.
 * 
 * All your money is taken.
 */
public class Robber extends GameComponent {

	Tokens tokens;

	public Robber(Game game, Tokens tokens) {
		super(game);
		this.tokens = tokens;
	}

	@Override
	public void init() {
		super.init();
		tokens.addNumOfTokens(this, 4);
	}

	@Override
	public void visit(Token token, Player player) {
		super.visit(token, player);
		tokens.removeToken(token);
		player.setMoney(0);
	}

	@Override
	public String toString() {
		return "Robber";
	}

}

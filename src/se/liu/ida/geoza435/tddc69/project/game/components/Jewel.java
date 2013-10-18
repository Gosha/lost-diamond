package se.liu.ida.geoza435.tddc69.project.game.components;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

public class Jewel extends GameComponent {

	String name;
	Integer worth, count;
	Tokens tokens;

	public Jewel(Game game, Tokens tokens, Integer count, Integer worth,
			String name) {
		super(game);
		this.tokens = tokens;
		this.count = count;
		this.worth = worth;
		this.name = name;
	}

	@Override
	public void init() {
		super.init();
		tokens.addNumOfTokens(this, count);
	}

	@Override
	public void visit(Token token, Player player) {
		super.visit(token, player);
		tokens.removeToken(token);
		player.addMoney(worth);
	}

	@Override
	public String toString() {
		return name + " worth: " + worth;
	}

}

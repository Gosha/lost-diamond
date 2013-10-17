package se.liu.ida.geoza435.tddc69.project.game.components;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

/**
 * Handles logic for what happens when one flips a {@link Token} with Africas
 * Star on it and the rules that apply to it;
 * <ul>
 * <li>There is only one Africa's Star</li> TODO
 * <li>If a player has the Africa's Star and is on a Start-{@link Mark} the game
 * ends.</li>
 * </ul>
 */
@SuppressWarnings("RefusedBequest")
public class AfricasStar extends GameComponent {

	public AfricasStar(Game game) {
		super(game);
	}

	@Override
	public void init() {
		game.getTokens().add(new Token(game.getBoard()
				.getMarksOfType(MarkType.city)
				.get(0), this));
	}

	@Override
	public void visit(Token token, Player player) {
		player.addToken(token);
		token.setAt(null);
		game.getTokens().remove(token);
	}

	@Override
	public String toString() {
		return "Africas Star";
	}

	@Override
	public void postTurn(Player player) {
		if (player.hasToken(this) && player.isOn(MarkType.start))
			game.setGameEnded(true);
	}

}
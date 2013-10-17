package se.liu.ida.geoza435.tddc69.project.game;

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
		game.tokens.add(new Token(game.board
				.getMarksOfType(MarkType.city)
				.get(0), this));
	}

	@Override
	public void visit(Token token, Player player) {
		player.addToken(token);
		token.setAt(null);
		game.tokens.remove(token);
	}

	@Override
	public String toString() {
		return "Africas Star";
	}

	@Override
	public void postTurn(Player player) {
		Debug.o("postTurn in AfricasStar");
		if (player.hasToken(this) && player.isOn(MarkType.start))
			game.gameEnded = true;
	}

}

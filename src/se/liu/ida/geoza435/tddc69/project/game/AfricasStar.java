package se.liu.ida.geoza435.tddc69.project.game;

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

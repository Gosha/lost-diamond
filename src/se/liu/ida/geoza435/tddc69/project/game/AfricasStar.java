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
		player.getTokens().add(token);
	}

}

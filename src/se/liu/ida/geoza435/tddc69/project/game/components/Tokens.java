package se.liu.ida.geoza435.tddc69.project.game.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

/**
 * When a player stands on a token or has just moved to a Token he can chose to
 * flip it.
 */
public class Tokens extends GameComponent {

	private List<Mark> availableMarks = null;

	public Tokens(Game game) {
		super(game);
	}

	@Override
	public void init() {
		super.init();
		this.availableMarks = new ArrayList<>(game.getBoard().getMarksOfType(
				MarkType.city));
		Collections.shuffle(this.availableMarks);
	}

	@Override
	public void addChoices(Player player, List<Choice> choices) {
		super.addChoices(player, choices);
		if (player.isOnToken())
			choices.add(new FlipChoice(game));
	}

	@Override
	public void addPostMoveChoices(Player player, List<Choice> choices) {
		super.addPostMoveChoices(player, choices);
		addChoices(player, choices);
	}

	public void addOne(GameComponent gameComponent) {
		Mark mark = availableMarks.remove(0);
		game.getTokens().add(new Token(mark, gameComponent));
	}

	public void addNumOfTokens(GameComponent gameComponent, Integer count) {
		for (int i = 0; !availableMarks.isEmpty() && i < count; i++) {
			addOne(gameComponent);
		}
	}

	public void removeToken(Token token) {
		token.setAt(null);
		game.getTokens().remove(token);
	}
}

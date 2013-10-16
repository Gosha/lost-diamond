package se.liu.ida.geoza435.tddc69.project.game;

public class FlipChoice implements Choice {

	boolean shouldPay;
	Game game;

	protected FlipChoice(Game game) {
		this.game = game;
	}

	@Override
	public void choose(Player player) {
		if (player.hasAtLeast(1000))
			shouldPay = player
					.presentBinaryChoice("Do you want to pay to flip?");
		else
			shouldPay = false;
	}

	@Override
	public void execute(Player player) {
		Token token = game.getTokenAt(player.getAt());
		Debug.o("FlipChoice execute()");
		if (shouldPay) {
			player.takeMoney(1000);
			removeToken(player, token);
		} else if (game.rollDie() >= 4) {
			removeToken(player, token);
		}
	}

	private void removeToken(Player player, Token token) {
		player.tokens.add(token);
		game.tokens.remove(token);
	}

	@Override
	public String toString() {
		return "Flip token";
	}

}

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
			token.visit(player);
		} else if (game.rollDie() >= 4) {
			token.visit(player);
		}
	}

	@Override
	public String toString() {
		return "Flip token";
	}

}

package se.liu.ida.geoza435.tddc69.project.game;

public abstract class Choice {
	Game game;

	public Choice(Game game) {
		this.game = game;
	}

	public abstract void choose(Player player);

	public abstract void execute(Player player);
}

package se.liu.ida.geoza435.tddc69.project.game;

public class Token {
	Mark at;
	GameComponent gameComponent;

	public Token(Mark at, GameComponent gameComponent) {
		this.at = at;
		this.gameComponent = gameComponent;
	}

	public void visit(Player player) {
		gameComponent.visit(this, player);
	}
}

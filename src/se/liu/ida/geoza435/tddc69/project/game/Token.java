package se.liu.ida.geoza435.tddc69.project.game;

public class Token {
	private Mark at;
	GameComponent gameComponent;

	public Token(Mark at, GameComponent gameComponent) {
		this.setAt(at);
		this.gameComponent = gameComponent;
	}

	public void visit(Player player) {
		gameComponent.visit(this, player);
	}

	public Mark getAt() {
		return at;
	}

	public void setAt(Mark at) {
		this.at = at;
	}
}

package se.liu.ida.geoza435.tddc69.project.game;

import se.liu.ida.geoza435.tddc69.project.Observable;

public class Token extends Observable {
	private Mark at;
	GameComponent gameComponent;

	public Token(Mark at, GameComponent gameComponent) {
		this.at = at;
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
		changed();
	}

	public GameComponent getGameComponent() {
		return gameComponent;
	}

	@Override
	public String toString() {
		return gameComponent.toString();
	}
}

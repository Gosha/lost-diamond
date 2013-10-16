package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Observable;

abstract public class Player extends Observable {
	Mark at;
	List<Token> tokens = new ArrayList<>();
	Game game;
	boolean hasMoved = false;

	int playerId;
	static int staticId = 1;

	Integer money = 5000;

	protected Player(Mark at, Game game) {
		this.at = at;
		this.game = game;
		playerId = staticId++;
	}

	public Mark getAt() {
		return at;
	}

	public void setAt(Mark at) {
		this.at = at;
		changed();
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void move(Mark to) {
		if (to != null) {
			setAt(to);
		}
		hasMoved = true;
	}

	public boolean isOn(MarkType... types) {
		boolean ret = false;
		for (MarkType type : types) {
			if (at.getType() == type) {
				ret = true;
				break;
			}
		}
		return ret;
	}

	public boolean isNextTo(ConnectionType type) {
		return !at.getNextMarks(1, type).isEmpty();
	}

	public boolean hasAtLeast(Integer money) {
		return this.money >= money;
	}

	public void addMoney(Integer add) {
		money += add;
		changed();
	}

	public void takeMoney(Integer take) {
		money -= take;
		changed();
	}

	public Integer getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return "{p" + playerId + ":" + at.toString() + "}";
	}

	public abstract Choice presentChoices(List<Choice> choices);

	public Choice presentChoices(List<Choice> choices, boolean compulsory) {
		return presentChoices(choices);
	}

	public abstract Mark chooseMark(List<MarkListContainer> marks);

	public abstract boolean presentBinaryChoice(String str);

	public boolean standsOnToken() {
		for (Token t : game.getTokens()) {
			if (t.getAt() == this.at)
				return true;
		}
		return false;
	}

	public boolean standsOnToken(GameComponent gameComponent) {
		Debug.o(this);
		for (Token t : game.getTokens()) {
			if (t.getAt() == this.at && t.getGameComponent() == gameComponent)
				return true;
		}
		return false;
	}

	public boolean hasToken(GameComponent gameComponent) {
		for (Token t : tokens) {
			if (t.getGameComponent() == gameComponent) {
				return true;
			}
		}
		return false;
	}
}

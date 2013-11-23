package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.components.Choice;
import se.liu.ida.geoza435.tddc69.project.game.components.GameComponent;
import se.liu.ida.geoza435.tddc69.project.gui.game.GUIPlayer;
import se.liu.ida.geoza435.tddc69.project.Observable;

/**
 * Defines some common functions all Players should use.
 * 
 * Subclasses of this class should make a player able to chose between choices
 * defined by GameComponents
 * 
 * @see TextPlayer
 * @see GUIPlayer
 */
abstract public class Player extends Observable {
	Mark at;
	private List<Token> tokens = new ArrayList<>();
	Game game;
	private Choice lastChoice = null;
	private boolean hasMoved = false;

	int playerId;
	static int staticId = 1;

	Integer money = 5000;

	protected Player(Mark at, Game game) {
		this.at = at;
		this.game = game;
		playerId = staticId;
		staticId += 1;
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

	public boolean hasAtLeast(Integer thisMuch) {
		return this.money >= thisMuch;
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

	public abstract Mark chooseMark(List<MarkListContainer> marks);

	public abstract boolean presentBinaryChoice(String message);

	public void addToken(Token token) {
		tokens.add(token);
		changed();
	}

	public boolean standsOnToken() {
		for (Token t : game.getTokens()) {
			if (t.getAt() == this.at)
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

	public Integer getNum() {
		return playerId;
	}

	public boolean hasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public abstract void visited(Token token);

	public void setMoney(int value) {
		money = value;
	}

	public Choice lastChoice() {
		return lastChoice;
	}

	public void setLastChoice(Choice choice) {
		this.lastChoice = choice;
	}
}

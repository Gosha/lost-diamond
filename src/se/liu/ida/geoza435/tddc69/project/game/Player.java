package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Observable;

abstract public class Player extends Observable {
	Mark at;
	List<Token> tokens = new ArrayList<>();

	protected Player(Mark at) {
		this.at = at;
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
	}

	@Override
	public String toString() {
		return "{p:" + at.toString() + "}";
	}

	public abstract Choice presentChoices(List<Choice> choices);

	public abstract Mark chooseMark(List<MarkListContainer> marks);
}

package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;

import se.liu.ida.geoza435.tddc69.project.Observable;

abstract public class Player extends Observable {
	Mark at;
	ArrayList<Token> tokens;

	public Player(Mark at) {
		this.at = at;
	}

	public Mark getAt() {
		return at;
	}

	public void setAt(Mark at) {
		this.at = at;
		changed();
	}

	public ArrayList<Token> getTokens() {
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

	public abstract Choice presentChoices(ArrayList<Choice> choices);

	public abstract Mark chooseMark(ArrayList<MarkListContainer> marks);
}

package se.liu.ida.geoza435.tddc69.project.game;

import java.io.Serializable;

/**
 * Immutable position class.
 */
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;
	int x, y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Position() {
		this(0, 0);
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}

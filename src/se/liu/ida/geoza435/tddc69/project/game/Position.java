package se.liu.ida.geoza435.tddc69.project.game;

/**
 * Immutable position class.
 */
public class Position {
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

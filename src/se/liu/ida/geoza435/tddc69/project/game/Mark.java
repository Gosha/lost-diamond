package se.liu.ida.geoza435.tddc69.project.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Observable;

@SuppressWarnings("CollectionDeclaredAsConcreteClass")
public class Mark extends Observable implements Serializable {
	private static final long serialVersionUID = 1L;
	MarkType type;
	Position position;

	// Not List or Collection because they aren't serializable
	ArrayList<Connection> connections;
	boolean selected;

	public Mark(MarkType type, Position position) {
		this.type = type;
		this.position = position;
		this.connections = new ArrayList<>();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
		changed();
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean set) {
		selected = set;
		changed();
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void deleteConnection(Connection connection) {
		connections.remove(connection);
	}

	public void addConnection(Connection connection) {
		connections.add(connection);
	}

	public MarkType getType() {
		return type;
	}

	public void setType(MarkType markType) {
		this.type = markType;
	}

	public ArrayList<MarkListContainer> getNextMarks(Integer upTo,
			ConnectionType ofType) {
		ArrayList<MarkListContainer> retMarks = new ArrayList<>();
		System.out.println(this);
		return getNextMarks(upTo, ofType, retMarks, this, 1);
	}

	@SuppressWarnings("ObjectEquality")
	private ArrayList<MarkListContainer> getNextMarks(Integer upTo,
			ConnectionType ofType, ArrayList<MarkListContainer> retMarks,
			Mark from, Integer distance) {
		if (upTo <= 0) {
			return retMarks;
		}
		for (MarkListContainer mlc : this.getAdjacentMarks()) {
			if (mlc.getMark() != from) {
				if (ofType == mlc.getConnectionType() || ofType == null) {
					retMarks.add(new MarkListContainer(mlc, distance));

					mlc.getMark()
							.getNextMarks(upTo - 1, ofType, retMarks, this,
									distance + 1);
				}
			}
		}
		return retMarks;
	}

	@SuppressWarnings({ "ReuseOfLocalVariable", "ObjectEquality" })
	private ArrayList<MarkListContainer> getAdjacentMarks() {
		ArrayList<MarkListContainer> retMarks = new ArrayList<>();

		for (Connection connection : connections) {
			Mark mark = connection.getA();
			if (mark != this)
				retMarks.add(new MarkListContainer(mark, connection.getType()));
			mark = connection.getB();
			if (mark != this)
				retMarks.add(new MarkListContainer(mark, connection.getType()));
		}
		return retMarks;
	}

	@Override
	public String toString() {
		return "[m:" + type.toString() + "@" + position.toString() + "]";
	}

}

package se.liu.ida.geoza435.tddc69.project.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Knows what {@link Mark}s and {@link Connection}s there are on the board.
 * Connection information is stored in the individual Connections
 */
// Because List is not Serializable
public class Board implements Serializable {
	private static final long serialVersionUID = 1L;

	List<Mark> marks;
	List<Connection> connections;

	public Board() {
		this.marks = new ArrayList<>();
		this.connections = new ArrayList<>();
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void createStubBoard() {
		// Magic numbers because it's a manual stub
		Mark m1 = addMark(new Mark(MarkType.normal, new Position(50, 50)));
		Mark m2 = addMark(new Mark(MarkType.boat, new Position(150, 150)));
		Mark m3 = addMark(new Mark(MarkType.start, new Position(151, 250)));
		Mark m4 = addMark(new Mark(MarkType.city, new Position(200, 50)));
		Mark m5 = addMark(new Mark(MarkType.normal, new Position(50, 170)));
		Mark m6 = addMark(new Mark(MarkType.normal, new Position(50, 320)));
		Mark m7 = addMark(new Mark(MarkType.normal, new Position(220, 320)));
		Mark m8 = addMark(new Mark(MarkType.normal, new Position(260, 170)));
		addConnection(new Connection(m1, m2, ConnectionType.flight));
		addConnection(new Connection(m3, m2, ConnectionType.boat));
		addConnection(new Connection(m2, m4));
		addConnection(new Connection(m3, m5));
		addConnection(new Connection(m3, m6));
		addConnection(new Connection(m3, m7));
		addConnection(new Connection(m3, m8));
	}

	public Mark addMark(Mark mark) {
		this.marks.add(mark);
		return mark;
	}

	public void addConnection(Connection connection) {
		this.connections.add(connection);
	}

	public void deleteMark(Mark mark) {
		marks.remove(mark);
		for (final Connection connection : mark.getConnections()) {
			if (!connection.getA().equals(mark)) {
				connection.getA().deleteConnection(connection);
			}
			if (!connection.getB().equals(mark)) {
				connection.getB().deleteConnection(connection);
			}
			deleteConnection(connection);
		}
	}

	public void deleteConnection(Connection connection) {
		connections.remove(connection);
	}

	public ArrayList<Mark> getMarksOfType(MarkType type) {
		ArrayList<Mark> retMarks = new ArrayList<>();

		for (Mark mark : marks) {
			if (mark.getType().equals(type))
				retMarks.add(mark);
		}

		return retMarks;
	}

	@Override
	public String toString() {
		return "Board [marks=" + marks + ", connections=" + connections + "]";
	}

	public List<Mark> getMarks() {
		return this.marks;
	}

	public void selectNone() {
		for (Mark mark : marks) {
			mark.setSelected(false);
		}
	}
}

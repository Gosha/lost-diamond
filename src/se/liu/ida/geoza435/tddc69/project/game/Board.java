package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
	List<Mark> marks;
	List<Connection> connections;

	public Board() {
		this.marks = new ArrayList<Mark>();
		this.connections = new ArrayList<Connection>();
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void createStubBoard() {
		Mark m1 = addMark(new Mark(MarkType.normal, new Position(50, 50)));
		Mark m2 = addMark(new Mark(MarkType.normal, new Position(150, 150)));
		Mark m3 = addMark(new Mark(MarkType.normal, new Position(151, 250)));
		Mark m4 = addMark(new Mark(MarkType.normal, new Position(200, 50)));
		addConnection(new Connection(m1, m2));
		addConnection(new Connection(m3, m2));
		addConnection(new Connection(m2, m4));
	}

	public Mark addMark(Mark m) {
		this.marks.add(m);
		return m;
	}

	public Connection addConnection(Connection c) {
		this.connections.add(c);
		return c;
	}

	@Override
	public String toString() {
		return "Board [marks=" + marks + ", connections=" + connections + "]";
	}

	public List<Mark> getMarks() {
		return this.marks;
	}
}

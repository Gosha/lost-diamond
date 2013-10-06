package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.Iterator;
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
		Mark m5 = addMark(new Mark(MarkType.normal, new Position(50, 170)));
		Mark m6 = addMark(new Mark(MarkType.normal, new Position(50, 320)));
		Mark m7 = addMark(new Mark(MarkType.normal, new Position(220, 320)));
		Mark m8 = addMark(new Mark(MarkType.normal, new Position(260, 170)));
		addConnection(new Connection(m1, m2));
		addConnection(new Connection(m3, m2));
		addConnection(new Connection(m2, m4));
		addConnection(new Connection(m3, m5));
		addConnection(new Connection(m3, m6));
		addConnection(new Connection(m3, m7));
		addConnection(new Connection(m3, m8));
	}

	public Mark addMark(Mark m) {
		this.marks.add(m);
		return m;
	}

	public Connection addConnection(Connection c) {
		this.connections.add(c);
		return c;
	}

	public void deleteMark(Mark m) {
		marks.remove(m);
		Iterator<Connection> iterator = m.getConnections().iterator();
		while (iterator.hasNext()) {
			Connection c = iterator.next();
			if (c.getA() != m) {
				c.getA().deleteConnection(c);
			}
			if (c.getB() != m) {
				c.getB().deleteConnection(c);
			}
			deleteConnection(c);
		}
	}

	public void deleteConnection(Connection c) {
		connections.remove(c);
	}

	@Override
	public String toString() {
		return "Board [marks=" + marks + ", connections=" + connections + "]";
	}

	public List<Mark> getMarks() {
		return this.marks;
	}

	public void selectNone() {
		for (Mark m : this.getMarks()) {
			m.setSelected(false);
		}
	}
}

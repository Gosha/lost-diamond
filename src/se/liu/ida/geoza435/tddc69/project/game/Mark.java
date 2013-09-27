package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.List;

public class Mark {
	MarkType type;
	Position position;
	List<Connection> connections;

	public Mark(MarkType type, Position position) {
		this.type = type;
		this.position = position;
		this.connections = new ArrayList<Connection>();
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void addConnection(Connection c) {
		connections.add(c);
	}

	public MarkType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "[m:" + type.toString() + "@" + position.toString() + "]";
	}
}

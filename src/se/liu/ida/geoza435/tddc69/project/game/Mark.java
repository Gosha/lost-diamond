package se.liu.ida.geoza435.tddc69.project.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;

public class Mark extends Observable implements Serializable {
	private static final long serialVersionUID = 1L;
	MarkType type;
	Position position;
	ArrayList<Connection> connections;
	ArrayList<Observer> observers;
	boolean selected;

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

	public void deleteConnection(Connection c) {
		connections.remove(c);
	}

	public void addConnection(Connection c) {
		connections.add(c);
	}

	public MarkType getType() {
		return type;
	}

	public void setType(MarkType markType) {
		this.type = markType;
	}

	@Override
	public String toString() {
		return "[m:" + type.toString() + "@" + position.toString() + "]";
	}

}

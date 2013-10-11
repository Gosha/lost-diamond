package se.liu.ida.geoza435.tddc69.project.game;

public class MarkListContainer {
	Mark mark;
	Integer distance;
	ConnectionType connectionType;

	public MarkListContainer(MarkListContainer mlc, Integer distance) {
		this.mark = mlc.getMark();
		this.connectionType = mlc.getConnectionType();
		this.distance = distance;
	}

	public MarkListContainer(Mark mark, ConnectionType connectionType) {
		this.mark = mark;
		this.connectionType = connectionType;
	}

	public Mark getMark() {
		return mark;
	}

	public Integer getDistance() {
		return distance;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	@Override
	public String toString() {
		return "[MLC:" + mark + ":" + distance + ":" + connectionType + "]";
	}

}

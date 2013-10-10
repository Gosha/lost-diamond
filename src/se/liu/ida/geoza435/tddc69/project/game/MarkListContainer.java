package se.liu.ida.geoza435.tddc69.project.game;

public class MarkListContainer {
	Mark mark;
	Integer distance;

	public MarkListContainer(Mark mark, Integer distance) {
		this.mark = mark;
		this.distance = distance;
	}

	public Mark getMark() {
		return mark;
	}

	public Integer getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return "[MLC:" + mark + ":" + distance;
	}

}

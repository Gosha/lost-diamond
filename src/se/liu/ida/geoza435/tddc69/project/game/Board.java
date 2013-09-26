package se.liu.ida.geoza435.tddc69.project.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
	List<Mark> marks;
	List<Connection> connections;

	public Board() {
		this.marks = new ArrayList<Mark>();
	}
}

package se.liu.ida.geoza435.tddc69.project;

import se.liu.ida.geoza435.tddc69.project.game.*;

public class TextTest {
	public static void main(String[] args) {
		Mark m = new Mark(MarkType.normal, new Position(1, 1));
		Player p = new Player(m);
		System.out.println(m);
		System.out.println(p);

		Board b = new Board();
		b.createStubBoard();
		System.out.println(b);
	}
}

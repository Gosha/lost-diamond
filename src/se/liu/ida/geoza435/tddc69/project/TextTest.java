package se.liu.ida.geoza435.tddc69.project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Position;
import se.liu.ida.geoza435.tddc69.project.game.TextPlayer;

public final class TextTest {
	private TextTest() {}

	public static void main(String[] args) {
		Mark mark = new Mark(MarkType.normal, new Position(1, 1));
		Player p = new TextPlayer(mark, null);
		System.out.println(mark);
		System.out.println(p);

		Board board = new Board();
		board.createStubBoard();

		try
		{
			FileOutputStream fileOut =
					new FileOutputStream("/tmp/employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(board);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in /tmp/employee.ser");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		System.out.println(board);
		try {
			FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Board e = (Board) in.readObject();
			in.close();
			fileIn.close();
			System.out.println(e);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Employee class not found");
			classNotFoundException.printStackTrace();
		}

	}
}

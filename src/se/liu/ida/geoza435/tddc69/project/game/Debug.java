package se.liu.ida.geoza435.tddc69.project.game;

public class Debug {

	static boolean debug = true;

	public static void o(Object str) {
		if (debug)
			System.out.println(str.toString());
	}
}

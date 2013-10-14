package se.liu.ida.geoza435.tddc69.project.game;

public final class Debug {

	static boolean debug = true;

	private Debug() {}

	public static void o(Object str) {
		if (debug)
			System.out.println(str.toString());
	}
}

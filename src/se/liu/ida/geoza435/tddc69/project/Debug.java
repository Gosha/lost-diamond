package se.liu.ida.geoza435.tddc69.project;

/**
 * Simple debugging facilities
 */
public final class Debug {

	static boolean debug = true;

	private Debug() {}

	public static void o(Object object) {
		if (debug)
			if (object == null)
				System.out.println("Null");
			else
				System.out.println(object.toString());
	}
}

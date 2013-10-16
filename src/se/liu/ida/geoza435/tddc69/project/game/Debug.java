package se.liu.ida.geoza435.tddc69.project.game;

public final class Debug {

	static boolean debug = true;

	private Debug() {}

	@SuppressWarnings("StaticMethodNamingConvention")
	public static void o(Object object) {
		if (debug)
			if (object == null)
				System.out.println("Null");
			else
				System.out.println(object.toString());
	}
}

package se.liu.ida.geoza435.tddc69.project;

import se.liu.ida.geoza435.tddc69.project.game.GameNotInitializedException;
import se.liu.ida.geoza435.tddc69.project.gui.game.GameController;

/**
 * Instantiates a GameController and nothing else. Dies and prints a stacktrace
 * on an error.
 */
public class Game {
	public static void main(String[] args) {
		try {
			new GameController();
		} catch (GameNotInitializedException e) {
			System.out.println("Couldn't start game:");
			e.printStackTrace();
		}
	}
}

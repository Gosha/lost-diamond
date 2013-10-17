package se.liu.ida.geoza435.tddc69.project;

import se.liu.ida.geoza435.tddc69.project.gui.game.GameController;

public class Game {
	public static void main(String[] args) {
		try {
			new GameController();
		} catch (Exception e) {
			System.out.println("Couldn't start game:");
			e.printStackTrace();
		}
	}
}

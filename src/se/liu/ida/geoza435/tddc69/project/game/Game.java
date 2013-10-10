package se.liu.ida.geoza435.tddc69.project.game;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Game {
	Board board;
	ArrayList<Token> tokens;
	ArrayList<Player> players;
	ArrayList<GameComponent> gameComponents;
	Player currentPlayer;
	boolean gameEnded = false;

	public Game() {
		this.board = new Board();
		this.players = new ArrayList<>();
		this.tokens = new ArrayList<>();
		this.gameComponents = new ArrayList<>();
		// this.gameComponents.add(new AfricasStar());
		this.gameComponents.add(new StandardMovement(this));
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void init() {
		for (GameComponent g : gameComponents) {
			g.init(this);
		}
		currentPlayer = players.get(0);
	}

	public void main() {
		init();
		while (!gameEnd()) {
			playTurn(currentPlayer);
			nextPlayer();
		}
	}

	private void nextPlayer() {
		currentPlayer = players.get(
				(players.indexOf(currentPlayer) + 1) % players.size());
	}

	private void playTurn(Player player) {
		ArrayList<Choice> choices = new ArrayList<>();
		for (GameComponent g : gameComponents) {
			g.addChoices(player, choices);
		}
		Choice choice = player.presentChoices(choices);
		choice.choose(player);
		choice.execute(player);

	}

	private boolean gameEnd() {
		return gameEnded;
	}

	public ArrayList<Mark> getMarksOfType(MarkType type) {
		// TODO: Move to Board?
		ArrayList<Mark> retMarks = new ArrayList<>();
		for (Mark m : board.getMarks()) {
			if (m.type == type)
				retMarks.add(m);
		}
		return retMarks;
	}

	public void loadBoard(String file) {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			board = (Board) in.readObject();
			in.close();
			fileIn.close();
			System.out.println(board);
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
	}

	public int rollDie() {
		return (int) (Math.random() * 5 + 1);
	}

}
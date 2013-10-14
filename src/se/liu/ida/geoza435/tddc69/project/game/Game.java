package se.liu.ida.geoza435.tddc69.project.game;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import se.liu.ida.geoza435.tddc69.project.resources.ResourceManagager;

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
		this.gameComponents.add(new Flight(this));
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
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
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

		if (!choices.isEmpty()) {
			Choice choice = player.presentChoices(choices);
			choice.choose(player);
			choice.execute(player);
		}

	}

	private boolean gameEnd() {
		return gameEnded;
	}

	public void loadBoard(String file) {
		try {
			InputStream istream = ResourceManagager.getStream(file);
			ObjectInputStream in = new ObjectInputStream(istream);
			board = (Board) in.readObject();
			in.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Board class not found");
			c.printStackTrace();
		}
	}

	public int rollDie() {
		return (int) (Math.random() * 5 + 1);
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}

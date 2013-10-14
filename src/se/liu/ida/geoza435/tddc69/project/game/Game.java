package se.liu.ida.geoza435.tddc69.project.game;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.resources.ResourceManagager;

public class Game {
	Board board;
	List<Token> tokens = new ArrayList<>();
	List<Player> players = new ArrayList<>();
	List<GameComponent> gameComponents = new ArrayList<>();
	Player currentPlayer;
	boolean gameEnded = false;
	private boolean initialized = false;

	public Game() {
		this.board = new Board();
		this.gameComponents.add(new AfricasStar(this));
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
		initialized = true;
	}

	public void main() throws Exception {

		if (!initialized) {
			throw new Exception("Game not initialized");
		}

		while (!isGameEnd()) {
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
		List<Choice> choices = new ArrayList<>();
		for (GameComponent g : gameComponents) {
			g.addChoices(player, choices);
		}

		if (!choices.isEmpty()) {
			Choice choice = player.presentChoices(choices);
			choice.choose(player);
			choice.execute(player);
		}

	}

	private boolean isGameEnd() {
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

	public List<Token> getTokens() {
		return tokens;
	}

}

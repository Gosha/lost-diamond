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
	Player currentPlayer = null;
	boolean gameEnded = false;
	private boolean initialized = false;

	public Game() {
		this.board = new Board();
		this.gameComponents.add(new StandardMovement(this));
		this.gameComponents.add(new Flight(this));
		this.gameComponents.add(new Tokens(this));
		this.gameComponents.add(new AfricasStar(this));
		this.gameComponents.add(new DoNothing(this));
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void init() {
		for (GameComponent g : gameComponents) {
			g.init();
		}
		currentPlayer = players.get(0);
		initialized = true;
	}

	public void start() throws Exception {

		if (!initialized) {
			throw new Exception("Game not initialized");
		}

		// noinspection CallToSimpleGetterFromWithinClass
		while (!isGameEnd()) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			playTurn(currentPlayer);
			nextPlayer();
		}
		Debug.o("Game end!");
	}

	private void nextPlayer() {
		currentPlayer = players.get(
				(players.indexOf(currentPlayer) + 1) % players.size());
	}

	private void playTurn(Player player) {
		List<Choice> choices = new ArrayList<>();

		player.hasMoved = false;

		for (GameComponent g : gameComponents) {
			g.addChoices(player, choices);
		}

		playerChoices(player, choices);

		choices.clear();

		if (player.hasMoved) {
			for (GameComponent g : gameComponents) {
				g.addPostMoveChoices(player, choices);
			}
		}

		playerChoices(player, choices);

		for (GameComponent g : gameComponents) {
			g.postTurn(player);
		}
	}

	private void playerChoices(Player player, List<Choice> choices) {
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
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("Board class not found");
			classNotFoundException.printStackTrace();
		}
	}

	public int rollDie() {
		int die = (int) (Math.random() * 5 + 1);
		Debug.o(die);
		return die;
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

	public List<Player> getPlayers() {
		return players;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	@SuppressWarnings("ObjectEquality")
	public Token getTokenAt(Mark at) {
		for (Token t : tokens) {
			if (t.getAt() == at)
				return t;
		}
		return null;
	}

}

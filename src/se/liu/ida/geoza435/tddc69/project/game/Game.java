package se.liu.ida.geoza435.tddc69.project.game;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.Debug;
import se.liu.ida.geoza435.tddc69.project.game.components.AfricasStar;
import se.liu.ida.geoza435.tddc69.project.game.components.Black;
import se.liu.ida.geoza435.tddc69.project.game.components.Boat;
import se.liu.ida.geoza435.tddc69.project.game.components.Choice;
import se.liu.ida.geoza435.tddc69.project.game.components.DoNothing;
import se.liu.ida.geoza435.tddc69.project.game.components.Flight;
import se.liu.ida.geoza435.tddc69.project.game.components.GameComponent;
import se.liu.ida.geoza435.tddc69.project.game.components.Jewel;
import se.liu.ida.geoza435.tddc69.project.game.components.Robber;
import se.liu.ida.geoza435.tddc69.project.game.components.StandardMovement;
import se.liu.ida.geoza435.tddc69.project.game.components.Tokens;
import se.liu.ida.geoza435.tddc69.project.resources.ResourceManagager;

/**
 * Handles game logic.
 * 
 * All rules are different {@link GameComponent}. (Strategy Pattern)
 * 
 * @see #start()
 */
public class Game {
	Board board;
	List<Token> tokens = new ArrayList<>();
	List<Player> players = new ArrayList<>();
	List<GameComponent> gameComponents = new ArrayList<>();
	Player currentPlayer = null;
	private boolean gameEnded = false;
	private boolean initialized = false;

	public Game() {
		this.board = new Board();
		this.gameComponents.add(new StandardMovement(this));
		this.gameComponents.add(new Flight(this));
		Tokens tokens = new Tokens(this);
		this.gameComponents.add(tokens);
		this.gameComponents.add(new AfricasStar(this, tokens));
		this.gameComponents.add(new Jewel(this, tokens, 2, 5000, "Ruby"));
		this.gameComponents.add(new Jewel(this, tokens, 3, 4000, "Emerald"));
		this.gameComponents.add(new Jewel(this, tokens, 6, 3000, "Topaz"));
		this.gameComponents.add(new Black(this, tokens));
		this.gameComponents.add(new Robber(this, tokens));
		DoNothing doNothing = new DoNothing(this);
		this.gameComponents.add(doNothing);
		this.gameComponents.add(new Boat(this, doNothing));
		this.gameComponents.add(new Black(this, tokens));
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
				// noinspection BusyWait
				Thread.sleep(100);
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

		player.setHasMoved(false);

		for (GameComponent g : gameComponents) {
			g.addChoices(player, choices);
		}

		playerChoices(player, choices);

		choices.clear();

		// noinspection ConstantConditions
		if (player.hasMoved()) {
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
			player.setLastChoice(choice);
		}
	}

	private boolean isGameEnd() {
		return isGameEnded();
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

	public boolean isGameEnded() {
		return gameEnded;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}

}

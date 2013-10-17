package se.liu.ida.geoza435.tddc69.project.game;

import se.liu.ida.geoza435.tddc69.project.GameTest;
import se.liu.ida.geoza435.tddc69.project.game.components.Choice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Simple AI-like player that doesn't require any interaction.
 * 
 * Can be used as a AI opponent in a game or as a test user.
 * 
 * @see GameTest
 */
public class TextPlayer extends Player {

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));

	public TextPlayer(Mark at, Game game) {
		super(at, game);
	}

	@Override
	public Choice presentChoices(List<Choice> choices) {
		for (Choice choice : choices)
			System.out.println(choice);

		return choices.get((int) (Math.random() * (choices.size())));
	}

	@Override
	public Mark chooseMark(List<MarkListContainer> marks) {
		return marks.isEmpty() ? null : marks.get(
				(int) (Math.random() * (marks.size()))).getMark();
	}

	@Override
	public boolean presentBinaryChoice(String message) {
		boolean response = (int) (Math.random() + 1) != 0;
		System.out.println(message + " " + response);
		return response;
	}

}

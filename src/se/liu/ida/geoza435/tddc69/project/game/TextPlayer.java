package se.liu.ida.geoza435.tddc69.project.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class TextPlayer extends Player {

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));

	public TextPlayer(Mark at) {
		super(at);
	}

	@Override
	public Choice presentChoices(List<Choice> choices) {
		for (Choice choice : choices)
			System.out.println(choice);

		return choices == null ? null : choices.get(0);
	}

	@Override
	public Mark chooseMark(List<MarkListContainer> marks) {
		// TODO Auto-generated method stub
		return marks.isEmpty() ? null : marks.get(0).getMark();
	}

}

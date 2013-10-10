package se.liu.ida.geoza435.tddc69.project.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextPlayer extends Player {

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));

	public TextPlayer(Mark at) {
		super(at);
	}

	@Override
	public Choice presentChoices(ArrayList<Choice> choices) {
		for (Choice c : choices)
			System.out.println(c);

		return choices == null ? null : choices.get(0);
	}

	@Override
	public Mark chooseMark(ArrayList<MarkListContainer> marks) {
		// TODO Auto-generated method stub
		return marks.size() > 0 ? marks.get(0).getMark() : null;
	}

}

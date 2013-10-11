package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.util.ArrayList;

import se.liu.ida.geoza435.tddc69.project.game.Choice;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkListContainer;
import se.liu.ida.geoza435.tddc69.project.game.Player;

public class GUIPlayer extends Player {

	BoardGameDisplay boardGameDisplay;

	public GUIPlayer(Mark at, BoardGameDisplay boardGameDisplay) {
		super(at);
		this.boardGameDisplay = boardGameDisplay;
	}

	@Override
	public Choice presentChoices(ArrayList<Choice> choices) {
		// TODO Actually present choices. JOption
		// http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
		// ?
		for (Choice c : choices)
			System.out.println(c);

		return choices == null ? null : choices.get(0);
	}

	@Override
	public Mark chooseMark(ArrayList<MarkListContainer> marks) {
		boardGameDisplay.getBoard().selectNone();
		for (MarkListContainer mlc : marks) {
			Mark m = mlc.getMark();
			m.setSelected(true);
		}
		// Wait..
		return marks.size() > 0 ? marks.get(0).getMark() : null;
	}

}

package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	public Choice presentChoices(List<Choice> choices) {
		// TODO Actually present choices. JOption
		// http://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
		// ?
		for (Choice choice : choices)
			System.out.println(choice);

		return choices == null ? null : choices.get(0);
	}

	@Override
	public Mark chooseMark(List<MarkListContainer> marks) {
		boardGameDisplay.getBoard().selectNone();

		Collection<MarkClickListener> listeners = new ArrayList<>();
		final ClickedMarkDisplay clickedMark = new ClickedMarkDisplay();
		for (MarkListContainer mlc : marks) {
			Mark mark = mlc.getMark();
			mark.setSelected(true);
			MarkClickListener listener = new MarkClickListener(mlc.getMark(),
					clickedMark, boardGameDisplay);
			listeners.add(listener);
		}
		try {
			synchronized (clickedMark) {
				clickedMark.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return marks.isEmpty() ? null : clickedMark.markDisplay.mark;
	}

}

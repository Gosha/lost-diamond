package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import se.liu.ida.geoza435.tddc69.project.game.Choice;
import se.liu.ida.geoza435.tddc69.project.game.Debug;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkListContainer;
import se.liu.ida.geoza435.tddc69.project.game.Player;

public class GUIPlayer extends Player {

	BoardGameDisplay boardGameDisplay;

	public GUIPlayer(Mark at, BoardGameDisplay boardGameDisplay, Game game) {
		super(at, game);
		this.boardGameDisplay = boardGameDisplay;
	}

	@Override
	public Choice presentChoices(List<Choice> choices) {

		if (choices.size() == 1) {
			return choices.get(0);
		}

		// TODO Better option choosing
		Choice response = null;
		while (response == null) {
			response = (Choice) JOptionPane.showInputDialog(
					this.boardGameDisplay.getParent(),
					"You can...",
					"Chose what you want to do",
					JOptionPane.INFORMATION_MESSAGE,
					null,
					choices.toArray(),
					choices.get(0));
		}

		return response;
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

		clickedMark.waitUntilSet();

		for (MarkClickListener mcl : listeners) {
			mcl.remove();
		}

		return clickedMark.getMarkDisplay().mark;
	}

	@Override
	public boolean presentBinaryChoice(String message) {
		int response = -1;
		while (response < 0) {
			response = JOptionPane.showConfirmDialog(boardGameDisplay, message,
					"Choose", JOptionPane.YES_NO_OPTION);
		}
		Debug.o(response);
		return response != 0;
	}

}

package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;
import se.liu.ida.geoza435.tddc69.project.game.Position;
import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;

/**
 * Add a new connected mark on mouseClicked() on {@link BoardDisplay}
 * 
 * Initially no {@link Mark}s are selected. The first time mouseClicked() is
 * called a mark is selected if a user pressed one, otherwise a warning is
 * issued.
 * 
 * If a mark is selected and the user presses somewhere on the board, a mark is
 * added there and connected to the selected mark.
 */
@SuppressWarnings("RefusedBequest")
public class AddListener extends MouseAdapter {

	BoardDisplay boardDisplay;

	public AddListener(BoardDisplay boardDisplay) {
		this.boardDisplay = boardDisplay;
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		MarkDisplay selectedMark = boardDisplay.getSelectedMark();
		if (selectedMark != null) {
			Mark newmark = new Mark(MarkType.normal,
					new Position(mouseEvent.getX() - MarkDisplay.SIZE / 2,
							mouseEvent.getY() - MarkDisplay.SIZE / 2));
			boardDisplay.getBoard().addMark(newmark);
			Connection newConnection = new Connection(selectedMark.mark,
					newmark);
			MarkDisplay newmd = boardDisplay.addMarkDisplay(newmark);
			boardDisplay.addNewConnectionDisplay(newConnection);
			boardDisplay.selectNone();
			boardDisplay.selectOne(newmd);
			boardDisplay.repaint();
		} else {
			JOptionPane.showMessageDialog(null,
					"You have to select a mark first.");
		}
	}
}

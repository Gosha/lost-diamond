package se.liu.ida.geoza435.tddc69.project.gui.game;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;

/**
 * Added to all Marks a GUIPlayer can move to.
 * 
 * When the first Mark is clicked, all MarkClickListeners are removed and the
 * clicked mark is found in a ClickedMarkDisplay.
 * 
 * @see ClickedMarkDisplay
 * @see GUIPlayer#chooseMark(List)
 */
public class MarkClickListener extends MouseAdapter {

	MarkDisplay markDisplay = null;
	final ClickedMarkDisplay clickedMarkDisplay;

	public MarkClickListener(Mark mark, ClickedMarkDisplay clickedMarkDisplay,
			BoardDisplay bd) {
		this.clickedMarkDisplay = clickedMarkDisplay;

		for (MarkDisplay aMarkDisplay : bd.getMarkDisplays()) {
			if (aMarkDisplay.getMark().equals(mark)) {
				this.markDisplay = aMarkDisplay;
				aMarkDisplay.addMouseListener(this);
				aMarkDisplay.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
		clickedMarkDisplay.setMarkDisplay(markDisplay);
	}

	public void remove() {
		markDisplay.removeMouseListener(this);
		markDisplay.setCursor(Cursor.getDefaultCursor());
	}
}

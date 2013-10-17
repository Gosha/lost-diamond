package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

@SuppressWarnings("RefusedBequest")
public class MarkClickListener extends MouseAdapter {

	MarkDisplay markDisplay = null;
	final ClickedMarkDisplay clickedMarkDisplay;

	@SuppressWarnings("ObjectEquality")
	public MarkClickListener(Mark mark, ClickedMarkDisplay clickedMarkDisplay,
			BoardDisplay bd) {
		this.clickedMarkDisplay = clickedMarkDisplay;

		for (MarkDisplay aMarkDisplay : bd.getMarkDisplays()) {
			if (aMarkDisplay.mark == mark) {
				this.markDisplay = aMarkDisplay;
				aMarkDisplay.addMouseListener(this);
				aMarkDisplay.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		clickedMarkDisplay.setMarkDisplay(markDisplay);
	}

	public void remove() {
		markDisplay.removeMouseListener(this);
		markDisplay.setCursor(Cursor.getDefaultCursor());
	}
}

package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

public class MarkClickListener extends MouseAdapter {

	MarkDisplay md;
	final ClickedMarkDisplay clickedMarkDisplay;

	public MarkClickListener(Mark mark, ClickedMarkDisplay clickedMarkDisplay,
			BoardDisplay bd) {
		this.clickedMarkDisplay = clickedMarkDisplay;

		for (MarkDisplay md : bd.getMarkDisplays()) {
			if (md.mark == mark) {
				this.md = md;
				md.addMouseListener(this);
				md.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		synchronized (clickedMarkDisplay) {
			this.clickedMarkDisplay.markDisplay = md;
			this.clickedMarkDisplay.notifyAll();
		}
	}

	public void remove() {
		md.removeMouseListener(this);
		md.setCursor(Cursor.getDefaultCursor());
	}
}

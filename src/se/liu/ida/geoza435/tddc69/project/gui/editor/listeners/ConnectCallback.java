package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;

import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;

/**
 * Connects two Marks.
 * 
 * Is called after a {@link SelectListener} is called. Used mostly to try out
 * callbacks instead of subclasses.
 */
public class ConnectCallback implements SelectCallback {

	@Override
	public boolean didRun(SelectListener from) {
		MarkDisplay markDisplay = from.boardDisplay.getSelectedMark();

		if (markDisplay != null) {
			if (!markDisplay.equals(from.markDisplay)) {
				from.boardDisplay.addNewConnectionDisplay(new Connection(
						markDisplay.getMark(),
						from.markDisplay.getMark()));
			}
			from.boardDisplay.selectNone();
			from.boardDisplay.repaint();
			return true;
		} else {
			return false;
		}
	}

}

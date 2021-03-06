package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;

/**
 * Marks a Mark as selected when it is clicked. Uses optional callbacks
 * 
 * @see SelectCallback
 * @see ConnectCallback
 */
public class SelectListener extends MouseAdapter {

	protected MarkDisplay markDisplay;
	protected BoardDisplay boardDisplay;
	protected SelectCallback callback = null;

	public SelectListener(MarkDisplay markDisplay, BoardDisplay bd) {
		this.markDisplay = markDisplay;
		this.boardDisplay = bd;
	}

	public SelectListener(MarkDisplay markDisplay, BoardDisplay bd,
			SelectCallback callback) {
		this(markDisplay, bd);
		this.callback = callback;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
		if (callback == null || !callback.didRun(this)) {
			boardDisplay.selectNone();
			boardDisplay.selectOne(markDisplay);
		}
	}

}

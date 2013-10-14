package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;

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
	public void mouseClicked(MouseEvent e) {
		if (callback == null || callback.run(this)) {
			boardDisplay.selectNone();
			boardDisplay.selectOne(markDisplay);
		}
	}

}

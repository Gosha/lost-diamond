package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;

public class SelectListener extends MouseAdapter {

	protected MarkDisplay md;
	protected BoardDisplay bd;
	protected SelectCallback callback;

	public SelectListener(MarkDisplay md, BoardDisplay bd) {
		this.md = md;
		this.bd = bd;
	}

	public SelectListener(MarkDisplay md, BoardDisplay bd,
			SelectCallback callback) {
		this(md, bd);
		this.callback = callback;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (callback == null || callback.run(this)) {
			bd.selectNone();
			bd.selectOne(md);
		}
	}

}

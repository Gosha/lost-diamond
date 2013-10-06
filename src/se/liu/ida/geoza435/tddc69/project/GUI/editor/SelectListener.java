package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;

public class SelectListener extends MouseAdapter {

	protected MarkDisplay md;
	protected BoardDisplay bd;

	public SelectListener(MarkDisplay md, BoardDisplay bd) {
		this.md = md;
		this.bd = bd;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		bd.selectNone();
		bd.selectOne(md);
	}

}

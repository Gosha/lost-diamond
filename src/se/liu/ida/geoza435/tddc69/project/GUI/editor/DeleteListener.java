package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;

@SuppressWarnings("RefusedBequest")
public class DeleteListener extends MouseAdapter {

	MarkDisplay md;
	BoardDisplay bd;

	public DeleteListener(MarkDisplay md, BoardDisplay bd) {
		this.md = md;
		this.bd = bd;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		bd.deleteMarkDisplay(md);
		bd.repaint();
	}

}

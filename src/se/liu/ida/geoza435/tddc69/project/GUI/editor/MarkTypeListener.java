package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.MarkType;

/**
 * Changes the type of a Mark when it is pressed.
 * 
 * Cycles through all available MarkTypes
 */
@SuppressWarnings("RefusedBequest")
public class MarkTypeListener extends MouseAdapter {

	MarkDisplay md;

	public MarkTypeListener(MarkDisplay md) {
		this.md = md;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MarkType type = md.mark.getType();
		MarkType[] vals = MarkType.values();
		md.mark.setType(
				vals[(type.ordinal() + 1) % vals.length]);
		md.repaint();
	}

}

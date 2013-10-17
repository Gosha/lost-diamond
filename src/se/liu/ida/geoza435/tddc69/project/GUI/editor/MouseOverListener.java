package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

/**
 * Changes the cursor to HAND_CURSOR on mouse-over.
 * 
 * Can apply to any component, but used only for MarkDisplays and
 * ConnectionDisplays
 */
@SuppressWarnings("RefusedBequest")
public class MouseOverListener extends MouseAdapter {
	JComponent component;

	public MouseOverListener(JComponent component) {
		this.component = component;
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		component.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}

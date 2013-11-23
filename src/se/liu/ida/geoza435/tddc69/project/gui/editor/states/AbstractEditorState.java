package se.liu.ida.geoza435.tddc69.project.gui.editor.states;

import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.editor.MouseListenerHandler;

/**
 * Defines some default actions for Editor states.
 */

public class AbstractEditorState {

	JButton button;

	AbstractEditorState(JButton button) {
		this.button = button;
	}

	public void enterState(MouseListenerHandler mouseListenerHandler) {
		button.setEnabled(false);
	}

	public void leaveState(MouseListenerHandler mouseListenerHandler) {
		BoardDisplay bd = mouseListenerHandler.getBoardDisplay();

		// Remove all listeners, both MouseListener and MouseMoitionListener
		for (MouseListener ml : bd.getMouseListeners()) {
			bd.removeMouseListener(ml);
		}
		for (MarkDisplay md : bd.getMarkDisplays()) {
			md.setCursor(Cursor.getDefaultCursor());
			for (MouseListener ma : md.getMouseListeners()) {
				md.removeMouseListener(ma);
			}
			for (MouseMotionListener ma : md.getMouseMotionListeners()) {
				md.removeMouseMotionListener(ma);
			}
		}
		button.setEnabled(true);
	}

}

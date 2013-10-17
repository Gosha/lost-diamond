package se.liu.ida.geoza435.tddc69.project.GUI.editor.states;

import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.editor.MouseListenerHandler;

@SuppressWarnings("AbstractClassWithoutAbstractMethods")
public abstract class AbstractEditorState {

	JButton button;

	AbstractEditorState(JButton button) {
		this.button = button;
	}

	public void enterState(MouseListenerHandler mouseListenerHandler) {
		button.setEnabled(false);
	}

	public void leaveState(MouseListenerHandler mouseListenerHandler) {
		BoardDisplay bd = mouseListenerHandler.getBoardDisplay();

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

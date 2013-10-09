package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseHandlerState;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

abstract class AbstractEditorState implements MouseHandlerState {

	EditorView container;
	JButton button;

	public AbstractEditorState(EditorView container, JButton button) {
		this.container = container;
		this.button = button;
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		button.setEnabled(false);
	}

	@Override
	public void leaveState(MouseListenerHandler mlh) {
		BoardDisplay bd = mlh.getBoardDisplay();

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

package se.liu.ida.geoza435.tddc69.project.gui.editor.states;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.editor.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.DragMotionListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.MouseOverListener;

/**
 * Adds {@link DragMotionListener}s and {@link MouseOverListener} to all Marks
 * so they can be moved.
 */
public class MoveState extends AbstractEditorState {

	public MoveState(JButton button) {
		super(button);
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		super.enterState(mouseListenerHandler);
		for (MarkDisplay markDisplay : mouseListenerHandler.getMarkDisplays()) {
			markDisplay.addMouseMotionListener(new DragMotionListener(
					markDisplay));
			markDisplay.addMouseMotionListener(new MouseOverListener(
					markDisplay));
		}
	}
}

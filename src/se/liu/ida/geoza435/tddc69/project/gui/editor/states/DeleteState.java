package se.liu.ida.geoza435.tddc69.project.gui.editor.states;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.editor.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.DeleteListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.MouseOverListener;

/**
 * Adds {@link DeleteListener} to all {@link MarkDisplay}s
 */
public class DeleteState extends AbstractEditorState {

	public DeleteState(JButton button) {
		super(button);
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		super.enterState(mouseListenerHandler);
		for (MarkDisplay markDisplay : mouseListenerHandler.getMarkDisplays()) {
			markDisplay.addMouseListener(new DeleteListener(markDisplay,
					mouseListenerHandler.getBoardDisplay()));
			markDisplay.addMouseMotionListener(new MouseOverListener(
					markDisplay));
		}
	}
}

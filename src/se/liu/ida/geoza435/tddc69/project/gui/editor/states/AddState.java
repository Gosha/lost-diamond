package se.liu.ida.geoza435.tddc69.project.gui.editor.states;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.editor.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.AddListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.MouseOverListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.SelectListener;

/**
 * Adds {@link AddListener} to the {@link BoardDisplay} and
 * {@link SelectListener} to all {@link MarkDisplay}s
 */
public class AddState extends AbstractEditorState {

	public AddState(JButton button) {
		super(button);
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		super.enterState(mouseListenerHandler);
		BoardDisplay bd = mouseListenerHandler.getBoardDisplay();
		bd.addMouseListener(new AddListener(bd));

		for (MarkDisplay markDisplay : mouseListenerHandler.getMarkDisplays()) {
			markDisplay.addMouseListener(new SelectListener(markDisplay, bd));
			markDisplay.addMouseMotionListener(new MouseOverListener(
					markDisplay));
		}
	}

	@Override
	public void leaveState(MouseListenerHandler mouseListenerHandler) {
		BoardDisplay boardDisplay = mouseListenerHandler.getBoardDisplay();
		boardDisplay.selectNone();
		super.leaveState(mouseListenerHandler);
	}

}

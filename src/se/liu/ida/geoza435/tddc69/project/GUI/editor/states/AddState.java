package se.liu.ida.geoza435.tddc69.project.GUI.editor.states;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.editor.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.GUI.editor.listeners.AddListener;
import se.liu.ida.geoza435.tddc69.project.GUI.editor.listeners.MouseOverListener;
import se.liu.ida.geoza435.tddc69.project.GUI.editor.listeners.SelectListener;

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

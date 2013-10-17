package se.liu.ida.geoza435.tddc69.project.gui.editor.states;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.editor.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.ConnectCallback;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.MouseOverListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.SelectListener;

/**
 * Adds {@link SelectListener} with {@link ConnectCallback}s to all Marks
 */
public class ConnectState extends AbstractEditorState {

	public ConnectState(JButton button) {
		super(button);
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		super.enterState(mouseListenerHandler);
		for (MarkDisplay markDisplay : mouseListenerHandler.getMarkDisplays()) {
			markDisplay.addMouseListener(new SelectListener(markDisplay,
					mouseListenerHandler.getBoardDisplay(),
					new ConnectCallback()));
			markDisplay.addMouseMotionListener(new MouseOverListener(
					markDisplay));
		}
	}
}

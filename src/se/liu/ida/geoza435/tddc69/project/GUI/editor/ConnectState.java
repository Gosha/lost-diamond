package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

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

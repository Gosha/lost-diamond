package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class ConnectState extends AbstractEditorState {

	public ConnectState(EditorView container, JButton button) {
		super(container, button);
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		super.enterState(mouseListenerHandler);
		for (MarkDisplay md : mouseListenerHandler.getMarkDisplays()) {
			md.addMouseListener(new SelectListener(md,
					mouseListenerHandler.getBoardDisplay(),
					new ConnectCallback()));
			md.addMouseMotionListener(new MouseOverListener(md));
		}
	}
}

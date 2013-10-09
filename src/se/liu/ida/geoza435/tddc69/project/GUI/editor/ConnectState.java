package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseListener;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class ConnectState extends AbstractEditorState {

	public ConnectState(EditorView container) {
		super(container);
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		container.getConnectButton().setEnabled(false);
		for (MarkDisplay md : mouseListenerHandler.getMarkDisplays()) {
			md.addMouseListener(new SelectListener(md,
					mouseListenerHandler.getBoardDisplay(),
					new ConnectCallback()));
		}
	}

	@Override
	public void leaveState(MouseListenerHandler mouseListenerHandler) {
		container.getConnectButton().setEnabled(true);
		for (MarkDisplay md : mouseListenerHandler.getMarkDisplays()) {
			for (MouseListener ml : md.getMouseListeners()) {
				md.removeMouseListener(ml);
			}
		}
	}

}

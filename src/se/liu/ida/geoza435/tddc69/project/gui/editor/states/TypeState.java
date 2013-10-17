package se.liu.ida.geoza435.tddc69.project.gui.editor.states;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.gui.ConnectionDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.editor.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.ConnectionTypeListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.MarkTypeListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.MouseOverListener;

/**
 * Adds {@link MarkTypeListener} to all {@link MarkDisplay}
 * {@link ConnectionTypeListener} to all {@link ConnectionDisplay} and
 * {@link MouseOverListener} to all of them.
 */
public class TypeState extends AbstractEditorState {

	public TypeState(JButton button) {
		super(button);
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
		super.enterState(mouseListenerHandler);
		for (MarkDisplay md : mouseListenerHandler.getMarkDisplays()) {
			md.addMouseListener(new MarkTypeListener(md));
			md.addMouseMotionListener(new MouseOverListener(md));
		}
		for (ConnectionDisplay cd : mouseListenerHandler
				.getConnectionDisplays()) {
			cd.addMouseListener(new ConnectionTypeListener(cd));
			cd.addMouseMotionListener(new MouseOverListener(cd));
		}
	}

}

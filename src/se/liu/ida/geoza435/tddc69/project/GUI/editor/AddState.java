package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseListener;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class AddState extends AbstractEditorState {

	public AddState(EditorView container) {
		super(container);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {

		BoardDisplay bd = mlh.getBoardDisplay();
		bd.addMouseListener(new AddListener(bd));

		container.getAddButton().setEnabled(false);

		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseListener(new SelectListener(md, bd));
		}
	}

	@Override
	public void leaveState(MouseListenerHandler mouseListenerHandler) {
		BoardDisplay bd = mouseListenerHandler.getBoardDisplay();
		bd.selectNone();
		for (MouseListener ml : bd.getMouseListeners()) {
			bd.removeMouseListener(ml);
		}
		for (MarkDisplay md : mouseListenerHandler.getMarkDisplays()) {
			for (MouseListener ml : md.getMouseListeners()) {
				md.removeMouseListener(ml);
			}
		}
		container.getAddButton().setEnabled(true);
	}

}

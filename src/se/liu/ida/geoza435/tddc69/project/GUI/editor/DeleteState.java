package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseListener;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class DeleteState extends AbstractEditorState {

	public DeleteState(EditorView container) {
		super(container);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {
		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseListener(new DeleteListener(md, mlh.getBoardDisplay()));
		}
		container.getDeleteButton().setEnabled(false);
	}

	@Override
	public void leaveState(MouseListenerHandler mlh) {
		BoardDisplay bd = mlh.getBoardDisplay();
		for (MarkDisplay md : bd.getMarkDisplays()) {
			for (MouseListener ma : md.getMouseListeners()) {
				md.removeMouseListener(ma);
			}
		}
		container.getDeleteButton().setEnabled(true);
	}

}

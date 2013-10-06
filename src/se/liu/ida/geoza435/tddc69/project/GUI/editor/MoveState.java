package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseMotionListener;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class MoveState extends AbstractEditorState {

	public MoveState(EditorView editorView) {
		super(editorView);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {

		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseMotionListener(new DragMotionListener(md));
		}
		container.getMoveButton().setEnabled(false);
	}

	@Override
	public void leaveState(MouseListenerHandler mlh) {

		BoardDisplay bd = mlh.getBoardDisplay();
		for (MarkDisplay md : bd.getMarkDisplays()) {
			for (MouseMotionListener ma : md.getMouseMotionListeners()) {
				md.removeMouseMotionListener(ma);
			}
		}

		container.getMoveButton().setEnabled(true);
	}
}

package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class MoveState extends AbstractEditorState {

	public MoveState(EditorView editorView) {
		super(editorView);
	}

	@Override
	public void enterState(MouseListenerHandler elh) {
		elh.getBoardDisplay().addMouseListener(new BoardClickListener());
		for (MarkDisplay md : elh.getMarkDisplays()) {
			md.addMouseMotionListener(new DragMotionListener(md));
		}
		container.getMoveButton().setEnabled(false);
	}

	@Override
	public void leaveState(MouseListenerHandler mouseListenerHandler) {
		container.getMoveButton().setEnabled(true);
	}

}

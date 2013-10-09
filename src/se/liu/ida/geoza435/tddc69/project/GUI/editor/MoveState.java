package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class MoveState extends AbstractEditorState {

	public MoveState(EditorView editorView, JButton button) {
		super(editorView, button);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {
		super.enterState(mlh);
		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseMotionListener(new DragMotionListener(md));
			md.addMouseMotionListener(new MouseOverListener(md));
		}
	}
}

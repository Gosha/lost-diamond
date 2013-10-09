package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class DeleteState extends AbstractEditorState {

	public DeleteState(EditorView container, JButton button) {
		super(container, button);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {
		super.enterState(mlh);
		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseListener(new DeleteListener(md, mlh.getBoardDisplay()));
			md.addMouseMotionListener(new MouseOverListener(md));
		}
	}
}
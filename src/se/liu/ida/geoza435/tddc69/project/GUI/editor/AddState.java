package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class AddState extends AbstractEditorState {

	public AddState(EditorView container) {
		super(container);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {
		mlh.getBoardDisplay();
		container.getAddButton().setEnabled(false);
	}

	@Override
	public void leaveState(MouseListenerHandler mouseListenerHandler) {
		container.getAddButton().setEnabled(true);
	}

}

package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import se.liu.ida.geoza435.tddc69.project.GUI.MouseHandlerState;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

class AbstractEditorState implements MouseHandlerState {

	EditorView container;

	public AbstractEditorState(EditorView container) {
		this.container = container;
	}

	@Override
	public void enterState(MouseListenerHandler mouseListenerHandler) {
	}

	@Override
	public void leaveState(MouseListenerHandler mouseListenerHandler) {
	}

}

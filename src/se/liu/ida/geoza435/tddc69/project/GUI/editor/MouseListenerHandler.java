package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.ConnectionDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.editor.states.AbstractEditorState;

/**
 * Handles the MouseListeners for the radio-like button in the EditorView.
 * 
 * Uses the State Pattern
 */
public class MouseListenerHandler {

	BoardDisplay bd;
	AbstractEditorState state = null;

	public MouseListenerHandler(BoardDisplay bd) {
		this.bd = bd;
	}

	public void setState(AbstractEditorState state) {
		if (this.state != null) {
			this.state.leaveState(this);
		}
		this.state = state;
		this.state.enterState(this);
	}

	public BoardDisplay getBoardDisplay() {
		return this.bd;
	}

	public List<MarkDisplay> getMarkDisplays() {
		return bd.getMarkDisplays();
	}

	public List<ConnectionDisplay> getConnectionDisplays() {
		return bd.getConnectionDisplays();
	}

	public void reenterState() {
		this.state.enterState(this);
	}

}

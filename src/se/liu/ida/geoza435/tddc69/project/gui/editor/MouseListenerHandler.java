package se.liu.ida.geoza435.tddc69.project.gui.editor;

import java.util.List;

import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.ConnectionDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.gui.editor.states.AbstractEditorState;

/**
 * Handles the MouseListeners for the radio-like button in the EditorView.
 * 
 * Uses the State Pattern
 */
public class MouseListenerHandler {

	BoardDisplay boardDisplay;
	AbstractEditorState state = null;

	public MouseListenerHandler(BoardDisplay bd) {
		this.boardDisplay = bd;
	}

	public void setState(AbstractEditorState state) {
		if (this.state != null) {
			this.state.leaveState(this);
		}
		this.state = state;
		this.state.enterState(this);
	}

	public BoardDisplay getBoardDisplay() {
		return this.boardDisplay;
	}

	public List<MarkDisplay> getMarkDisplays() {
		return boardDisplay.getMarkDisplays();
	}

	public List<ConnectionDisplay> getConnectionDisplays() {
		return boardDisplay.getConnectionDisplays();
	}

	public void reenterState() {
		this.state.enterState(this);
	}

}

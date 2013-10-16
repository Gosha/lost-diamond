package se.liu.ida.geoza435.tddc69.project.GUI;

import java.util.List;

public class MouseListenerHandler {

	BoardDisplay bd;
	MouseHandlerState state = null;

	public MouseListenerHandler(BoardDisplay bd) {
		this.bd = bd;
	}

	public void setState(MouseHandlerState state) {
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

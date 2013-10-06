package se.liu.ida.geoza435.tddc69.project.GUI;

import java.util.List;

public class MouseListenerHandler {

	BoardDisplay bd;
	MouseHandlerState state;

	public MouseListenerHandler(BoardDisplay bd) {
		this.bd = bd;
	}

	public void setState(MouseHandlerState state) {
		this.state = state;
		this.state.setupState(this);
	}

	public BoardDisplay getBoardDisplay() {
		return this.bd;
	}

	public List<MarkDisplay> getMarkDisplays() {
		return bd.getMarkDisplays();
	}
}

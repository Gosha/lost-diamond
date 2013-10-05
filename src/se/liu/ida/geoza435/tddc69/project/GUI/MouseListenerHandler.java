package se.liu.ida.geoza435.tddc69.project.GUI;

public class MouseListenerHandler {

	public MouseListenerInstance getMouseListenerInstance(MarkDisplay md) {
		return new MouseListenerInstance(this, md);
	}

}

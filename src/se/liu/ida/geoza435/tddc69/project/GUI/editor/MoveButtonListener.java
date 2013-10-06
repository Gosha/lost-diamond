package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class MoveButtonListener implements ActionListener {

	MouseListenerHandler mlh;
	EditorView container;

	public MoveButtonListener(MouseListenerHandler mlh, EditorView container) {
		this.mlh = mlh;
		this.container = container;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mlh.setState(new MoveState(container));
	}

}

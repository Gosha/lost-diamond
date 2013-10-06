package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class AddButtonListener implements ActionListener {

	MouseListenerHandler mlh;
	EditorView container;

	public AddButtonListener(MouseListenerHandler mlh, EditorView editorView) {
		this.mlh = mlh;
		this.container = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mlh.setState(new AddState(container));
	}

}

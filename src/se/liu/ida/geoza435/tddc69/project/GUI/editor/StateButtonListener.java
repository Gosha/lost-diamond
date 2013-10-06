package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class StateButtonListener implements ActionListener {

	MouseListenerHandler mlh;
	EditorView container;
	AbstractEditorState state;

	public StateButtonListener(MouseListenerHandler mlh,
			EditorView editorView,
			AbstractEditorState state) {
		this.mlh = mlh;
		this.container = editorView;
		this.state = state;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		mlh.setState(state);
	}

}

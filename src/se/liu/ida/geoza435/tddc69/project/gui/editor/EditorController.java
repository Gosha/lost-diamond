package se.liu.ida.geoza435.tddc69.project.gui.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.LoadListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.SaveListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.listeners.StateButtonListener;
import se.liu.ida.geoza435.tddc69.project.gui.editor.states.AddState;
import se.liu.ida.geoza435.tddc69.project.gui.editor.states.ConnectState;
import se.liu.ida.geoza435.tddc69.project.gui.editor.states.DeleteState;
import se.liu.ida.geoza435.tddc69.project.gui.editor.states.MoveState;
import se.liu.ida.geoza435.tddc69.project.gui.editor.states.TypeState;

/**
 * Sets up the Editor. Adds states for the Radio-like buttons. And
 * ActionListeners for the Load and Save facilities.
 */
public class EditorController {

	final EditorView editorView;
	Board board = new Board();

	public EditorController() {
		editorView = new EditorView(board);
	}

	public void start() {

		board.createStubBoard();

		final MouseListenerHandler mlh = new MouseListenerHandler(
				editorView.getBoardDisplay());

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				editorView.initUI();
				editorView.getQuitButton().addActionListener(
						new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								System.exit(0);
							}
						});

				// Radio buttons
				JButton moveButton = editorView.getMoveButton();
				moveButton.addActionListener(
						new StateButtonListener(mlh,
								new MoveState(moveButton)));
				JButton addButton = editorView.getAddButton();
				addButton.addActionListener(
						new StateButtonListener(mlh,
								new AddState(addButton)));
				JButton deleteButton = editorView.getDeleteButton();
				deleteButton.addActionListener(
						new StateButtonListener(mlh,
								new DeleteState(deleteButton)));
				JButton connectButton = editorView.getConnectButton();
				connectButton.addActionListener(
						new StateButtonListener(mlh,
								new ConnectState(connectButton)));
				JButton typeButton = editorView.getTypeButton();
				typeButton.addActionListener(
						new StateButtonListener(mlh,
								new TypeState(typeButton)));

				// Load/Save buttons
				editorView.getSaveButton().addActionListener(
						new SaveListener(editorView.getBoardDisplay()));
				editorView.getLoadButton().addActionListener(
						new LoadListener(editorView.getBoardDisplay(),
								mlh));

				editorView.getBoardDisplay().loadBoard();

				mlh.setState(new MoveState(moveButton));

				editorView.setVisible(true);
			}
		});
	}
}

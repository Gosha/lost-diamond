package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.game.Board;

/**
 * Sets up the Editor. Adds states for the Radio-like buttons. And
 * ActionListeners for the Load and Save facilities.
 */
public class EditorController {

	final EditorView editorView;
	Board board = new Board();

	public EditorController() {

		editorView = new EditorView(board);
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

				// TODO Duplicate code
				// Radio buttons
				JButton moveButton = editorView.getMoveButton();
				moveButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new MoveState(editorView, moveButton)));
				JButton addButton = editorView.getAddButton();
				addButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new AddState(addButton)));
				JButton deleteButton = editorView.getDeleteButton();
				deleteButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new DeleteState(deleteButton)));
				JButton connectButton = editorView.getConnectButton();
				connectButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new ConnectState(connectButton)));
				JButton typeButton = editorView.getTypeButton();
				typeButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new TypeState(typeButton)));

				// Load/Save buttons
				editorView.getSaveButton().addActionListener(
						new SaveListener(editorView.getBoardDisplay()));
				editorView.getLoadButton().addActionListener(
						new LoadListener(editorView.getBoardDisplay(),
								mlh));

				editorView.getBoardDisplay().loadBoard();

				mlh.setState(new MoveState(editorView, moveButton));

				editorView.setVisible(true);
			}
		});
	}
}

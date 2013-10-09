package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

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

				JButton moveButton = editorView.getMoveButton();
				moveButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new MoveState(editorView, moveButton)));
				JButton addButton = editorView.getAddButton();
				addButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new AddState(editorView, addButton)));
				JButton deleteButton = editorView.getDeleteButton();
				deleteButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new DeleteState(editorView, deleteButton)));
				JButton connectButton = editorView.getConnectButton();
				connectButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new ConnectState(editorView, connectButton)));
				JButton typeButton = editorView.getTypeButton();
				typeButton.addActionListener(
						new StateButtonListener(mlh, editorView,
								new TypeState(editorView, typeButton)));

				editorView.getSaveButton().addActionListener(
						new SaveListener(editorView.getBoardDisplay()));

				BoardDisplay boardDisplay = editorView.getBoardDisplay();

				for (Mark m : editorView.getBoard().getMarks()) {
					boardDisplay.addMarkDisplay(m);
				}

				for (Connection c : editorView.getBoard().getConnections()) {
					boardDisplay.addConnection(c);
				}

				mlh.setState(new MoveState(editorView, moveButton));

				editorView.setVisible(true);
			}
		});
	}
}

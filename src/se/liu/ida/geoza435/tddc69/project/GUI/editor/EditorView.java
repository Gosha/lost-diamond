package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Board;

@SuppressWarnings("serial")
public class EditorView extends JFrame {

	JButton quitButton = new JButton("Quit");
	JButton saveButton = new JButton("Save");
	JButton addButton = new JButton("Add");
	JButton moveButton = new JButton("Move");
	JButton deleteButton = new JButton("Delete");
	JButton connectButton = new JButton("Connect");
	JButton typeButton = new JButton("Change Type");
	JPanel buttonPanel = new JPanel();
	BoardDisplay boardDisplay;

	Board board;

	public EditorView(Board board) {

		this.board = board;
		this.boardDisplay = new BoardDisplay(board);

	}

	public void initUI() {
		setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(0, 1));

		getContentPane().add(buttonPanel, BorderLayout.WEST);

		buttonPanel.add(quitButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(moveButton);
		buttonPanel.add(addButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(connectButton);
		buttonPanel.add(typeButton);

		JScrollPane spane = new JScrollPane();

		spane.setViewportView(boardDisplay);

		add(spane, BorderLayout.CENTER);

		setTitle("Editor");
		setLocationByPlatform(true);
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JButton getConnectButton() {
		return connectButton;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getMoveButton() {
		return moveButton;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getTypeButton() {
		return typeButton;
	}

	public BoardDisplay getBoardDisplay() {
		return boardDisplay;
	}

	public Board getBoard() {
		return board;
	}
}

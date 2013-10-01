package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.ConnectionDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

@SuppressWarnings("serial")
public class EditorView extends JFrame {

	JButton quitButton = new JButton("Quit");
	JButton addButton = new JButton("Add");
	JButton moveButton = new JButton("Move");
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
		buttonPanel.setPreferredSize(new Dimension(100, 100));

		getContentPane().add(buttonPanel, BorderLayout.WEST);

		buttonPanel.add(quitButton);
		buttonPanel.add(moveButton);
		buttonPanel.add(addButton);

		for (Mark m : board.getMarks()) {
			boardDisplay.add(new MarkDisplay(m));
		}

		for (Connection c : board.getConnections()) {
			boardDisplay.add(new ConnectionDisplay(c));
		}

		JScrollPane spane = new JScrollPane();

		spane.setViewportView(boardDisplay);

		add(spane, BorderLayout.CENTER);

		setTitle("Editor");
		setLocationByPlatform(true);
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JButton getQuitButton() {
		return quitButton;
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

	public BoardDisplay getBoardDisplay() {
		return boardDisplay;
	}

	public Board getBoard() {
		return board;
	}
}

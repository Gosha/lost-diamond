package se.liu.ida.geoza435.tddc69.project.gui.editor;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;

/**
 * Layout for the Editor.
 * 
 * <pre>
 *         BorderLayout
 *       /              \
 *      |                |
 *   GridLayout in WEST
 *      \  /
 *      +--+-------------+
 *      +--+             |
 *      +--+             |
 *      +--+             |
 *      +--+-------------+
 *          \           /
 *          BoardDisplay in CENTER
 * </pre>
 */
public class EditorView extends JFrame {

	JButton quitButton = new JButton("Quit");
	JButton saveButton = new JButton("Save");
	JButton loadButton = new JButton("Load");
	JButton addButton = new JButton("Add");
	JButton moveButton = new JButton("Move");
	JButton deleteButton = new JButton("Delete");
	JButton connectButton = new JButton("Connect");
	JButton typeButton = new JButton("Change Type");
	JPanel buttonPanel = new JPanel();
	BoardDisplay boardDisplay;

	final static int WIDTH = 600;
	final static int HEIGHT = 500;

	public EditorView(Board board) {
		this.boardDisplay = new BoardDisplay(board);
	}

	public void initUI() {
		setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout(0, 1));

		getContentPane().add(buttonPanel, BorderLayout.WEST);

		buttonPanel.add(quitButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
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
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

	public JButton getLoadButton() {
		return loadButton;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getMoveButton() {
		return moveButton;
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
}

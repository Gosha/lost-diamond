package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.resources.ResourceManagager;

@SuppressWarnings("serial")
public class BoardDisplay extends JPanel {
	private Board board;
	List<MarkDisplay> markDisplays;
	List<ConnectionDisplay> connectionDisplays;
	MarkDisplay selectedMark;
	ImageIcon background;

	public BoardDisplay(Board board) {
		this.markDisplays = new ArrayList<MarkDisplay>();
		this.connectionDisplays = new ArrayList<ConnectionDisplay>();
		this.board = board;
		this.setLayout(null);
		// TODO Automatic resizing / Set size of board
		// TODO Loadable map
		URL url = ResourceManagager.getURL("africa.jpg");
		background = new ImageIcon(url);

		Dimension size = new Dimension(background.getIconWidth(),
				background.getIconHeight());
		this.setSize(size);
		this.setPreferredSize(size);

	}

	public MarkDisplay addMarkDisplay(Mark mark) {
		MarkDisplay newMarkDisplay = new MarkDisplay(mark);
		this.markDisplays.add(newMarkDisplay);
		this.add(newMarkDisplay);
		return newMarkDisplay;
	}

	public ConnectionDisplay addConnection(Connection connection) {
		ConnectionDisplay newConnDisplay = new ConnectionDisplay(connection);
		this.connectionDisplays.add(newConnDisplay);
		this.add(newConnDisplay);
		return newConnDisplay;
	}

	public void addNewConnectionDisplay(Connection connection) {
		addConnection(connection);
		this.board.addConnection(connection);
	}

	public List<MarkDisplay> getMarkDisplays() {
		return this.markDisplays;
	}

	public void deleteMarkDisplay(MarkDisplay markDisplay) {

		Iterator<ConnectionDisplay> iterator = connectionDisplays.iterator();

		while (iterator.hasNext()) {
			ConnectionDisplay connectionDisplay = iterator.next();
			if (markDisplay.mark.getConnections()
					.contains(connectionDisplay.connection)) {
				this.remove(connectionDisplay);
				iterator.remove();
			}
		}

		board.deleteMark(markDisplay.mark);
		markDisplay.remove(markDisplay);
		this.remove(markDisplay);
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void loadBoard() {
		for (Mark mark : board.getMarks()) {
			addMarkDisplay(mark);
		}

		for (Connection connection : board.getConnections()) {
			addConnection(connection);
		}
	}

	public void selectNone() {
		selectedMark = null;
		board.selectNone();
	}

	public void selectOne(MarkDisplay markDisplay) {
		selectedMark = markDisplay;
		markDisplay.mark.setSelected(true);
	}

	public MarkDisplay getSelectedMark() {
		return selectedMark;
	}

	public void clearBoard() {
		this.connectionDisplays.clear();
		this.markDisplays.clear();
		this.removeAll();
	}

	public Board getBoard() {
		return board;
	}

	public List<ConnectionDisplay> getConnectionDisplays() {
		return this.connectionDisplays;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}

}

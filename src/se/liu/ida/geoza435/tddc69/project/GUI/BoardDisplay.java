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
	// TODO: Better names
	List<MarkDisplay> md;
	List<ConnectionDisplay> cd;
	MarkDisplay selectedMark;
	ImageIcon background;

	public BoardDisplay(Board board) {
		this.md = new ArrayList<MarkDisplay>();
		this.cd = new ArrayList<ConnectionDisplay>();
		this.board = board;
		this.setLayout(null);
		// TODO Automatic resizing / Set size of board
		this.setSize(870, 550);
		this.setPreferredSize(new Dimension(870, 550));
		// TODO Loadable map
		URL url = ResourceManagager.getURL("africa.jpg");
		background = new ImageIcon(url);

		Dimension size = new Dimension(background.getIconWidth(),
				background.getIconHeight());
		this.setSize(size);
		this.setPreferredSize(size);

	}

	public MarkDisplay addMarkDisplay(Mark m) {
		MarkDisplay newMarkDisplay = new MarkDisplay(m);
		this.md.add(newMarkDisplay);
		this.add(newMarkDisplay);
		return newMarkDisplay;
	}

	public ConnectionDisplay addConnection(Connection c) {
		ConnectionDisplay newCD = new ConnectionDisplay(c);
		this.cd.add(newCD);
		this.add(newCD);
		return newCD;
	}

	public void addNewConnectionDisplay(Connection c) {
		addConnection(c);
		this.board.addConnection(c);
	}

	public List<MarkDisplay> getMarkDisplays() {
		return this.md;
	}

	public void deleteMarkDisplay(MarkDisplay md) {

		Iterator<ConnectionDisplay> iterator = cd.iterator();

		while (iterator.hasNext()) {
			ConnectionDisplay c = iterator.next();
			if (md.mark.getConnections().contains(c.connection)) {
				this.remove(c);
				iterator.remove();
			}
		}

		board.deleteMark(md.mark);
		md.remove(md);
		this.remove(md);
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void loadBoard() {
		for (Mark m : getBoard().getMarks()) {
			addMarkDisplay(m);
		}

		for (Connection c : getBoard().getConnections()) {
			addConnection(c);
		}
	}

	public void selectNone() {
		selectedMark = null;
		getBoard().selectNone();
	}

	public void selectOne(MarkDisplay md) {
		selectedMark = md;
		md.mark.setSelected(true);
	}

	public MarkDisplay getSelectedMark() {
		return selectedMark;
	}

	public void clearBoard() {
		this.cd.clear();
		this.md.clear();
		this.removeAll();
	}

	public Board getBoard() {
		return board;
	}

	public List<ConnectionDisplay> getConnectionDisplays() {
		return this.cd;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}

}

package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

@SuppressWarnings("serial")
public class BoardDisplay extends JPanel {
	Board board;
	// TODO: Better names
	List<MarkDisplay> md;
	List<ConnectionDisplay> cd;

	public BoardDisplay(Board board) {
		this.md = new ArrayList<MarkDisplay>();
		this.cd = new ArrayList<ConnectionDisplay>();
		this.board = board;
		this.setLayout(null);
		this.setSize(400, 400);
		this.setPreferredSize(new Dimension(400, 400));

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Gör saker!
				JOptionPane.showMessageDialog(null, "Hej");
			}

		});
	}

	public void addMarkDisplay(Mark m) {
		MarkDisplay newMarkDisplay = new MarkDisplay(m);
		this.md.add(newMarkDisplay);
		this.add(newMarkDisplay);
	}

	public void addConnectionDisplay(Connection c) {
		ConnectionDisplay newCD = new ConnectionDisplay(c);
		this.cd.add(newCD);
		this.add(newCD);
	}
}

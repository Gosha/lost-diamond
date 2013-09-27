package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.Scrollable;
import javax.swing.JPanel;

import se.liu.ida.geoza435.tddc69.project.game.Board;

public class BoardDisplay extends JPanel implements Scrollable {
	Board board;

	public BoardDisplay(Board board) {
		this.board = board;
		this.setLayout(null);
		this.setSize(400, 400);
		this.setPreferredSize(new Dimension(400, 400));
	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return new Dimension(300, 300);
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// TODO Auto-generated method stub
		return 0;
	}

}

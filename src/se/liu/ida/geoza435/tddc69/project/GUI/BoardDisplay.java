package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.Scrollable;
import javax.swing.JPanel;

import se.liu.ida.geoza435.tddc69.project.game.Board;

public class BoardDisplay extends JPanel  {
	Board board;

	public BoardDisplay(Board board) {
		this.board = board;
		this.setLayout(null);
		this.setSize(400, 400);
		this.setPreferredSize(new Dimension(400, 400));
	}
}
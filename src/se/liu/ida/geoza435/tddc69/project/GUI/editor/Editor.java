package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.ConnectionDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Board;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Mark;

@SuppressWarnings("serial")
public class Editor extends JFrame {

	public Editor() {

		JPanel panel = new JPanel();

		setLayout(new BorderLayout());
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(100, 100));
		getContentPane().add(panel, BorderLayout.WEST);

		JButton button = new JButton("Quit");
		button.setBounds(10, 0, 80, 30);

		// JButton button2 = new JButton("Hej");
		// button2.setBounds(15, 15, 300, 300);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		button.setVisible(true);
		panel.add(button);

		Board board = new Board();
		board.createStubBoard();
		BoardDisplay b = new BoardDisplay(board);

		for (Mark m : board.getMarks()) {
			b.add(new MarkDisplay(m));
		}

		for (Connection c : board.getConnections()) {
			b.add(new ConnectionDisplay(c));
		}

		JScrollPane spane = new JScrollPane();

		spane.setViewportView(b);

		add(spane, BorderLayout.CENTER);

		setTitle("Wut");
		setLocationByPlatform(true);
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Editor e = new Editor();
				e.setVisible(true);
			}
		});
	}
}

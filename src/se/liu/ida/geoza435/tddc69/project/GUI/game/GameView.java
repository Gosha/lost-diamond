package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import se.liu.ida.geoza435.tddc69.project.game.Game;

@SuppressWarnings("serial")
public class GameView extends JFrame {

	// TODO Public variables
	BoardGameDisplay boardGameDisplay;
	Game game;

	public GameView(Game game) {
		this.game = game;
		this.boardGameDisplay = new BoardGameDisplay(game.getBoard());
	}

	public void initUI() {
		JScrollPane spane = new JScrollPane();

		spane.setViewportView(boardGameDisplay);
		spane.getVerticalScrollBar().setUnitIncrement(16);

		add(spane, BorderLayout.CENTER);

		JPanel p = new JPanel();
		JButton b = new JButton("Hej");
		JButton bb = new JButton("Hej");
		JButton bbb = new JButton("Hej");

		b.setBounds(0, 0, 40, 40);
		p.setBounds(0, 0, 100, 100);
		p.setSize(100, 100);
		p.setOpaque(false);
		p.setLayout(new GridBagLayout());
		p.add(b);
		p.add(bb);
		p.add(bbb);
		p.setBackground(new Color(100, 100, 100, 10));
		getRootPane().getGlassPane().setVisible(true);

		getRootPane().setGlassPane(p);

		// TODO: Constants
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}

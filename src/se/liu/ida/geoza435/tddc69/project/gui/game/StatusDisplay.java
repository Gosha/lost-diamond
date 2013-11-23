package se.liu.ida.geoza435.tddc69.project.gui.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

/**
 * Displays status for all Players in text-format
 */
public class StatusDisplay extends JPanel implements Observer {

	JLabel label;
	JPanel panel;
	private Game game;

	private static final Color FOREGROUND_COLOUR = new Color(242, 242, 242);
	private static final Color BACKGROUND_COLOUR = new Color(0, 0, 0, 200);

	private static final int START_POSITION = 20;

	public StatusDisplay(Game game) {
		this.game = game;
		setLayout(null);

		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.setBounds(START_POSITION, START_POSITION, 0, 0);

		label = new JLabel("NOT SET");
		label.setForeground(FOREGROUND_COLOUR);

		panel.add(label);

		panel.setBackground(BACKGROUND_COLOUR);
		add(panel, BorderLayout.WEST);

		setOpaque(false);
		setVisible(true);

		for (Player p : game.getPlayers()) {
			p.observe(this);
		}
	}

	@Override
	public void notifyChange(Observable observable) {
		updateDisplay();
	}

	private void updateDisplay() {
		StringBuilder txt = new StringBuilder();
		for (Player p : game.getPlayers()) {
			txt.append("Player ").append(p.getNum());
			if (game.getCurrentPlayer() == p) {
				txt.append(" *");
			}
			txt.append("<br>");
			txt.append("Money: ").append(p.getMoney()).append("<br>");
			txt.append("Has: ");
			for (Token token : p.getTokens()) {
				txt.append(token).append(" ");
			}
			txt.append("<br>");
		}
		txt.insert(0, "<html>").append("</html>");
		label.setText(txt.toString());
		panel.setSize(label.getPreferredSize());
		System.out.println(txt);
		repaint();
	}

}

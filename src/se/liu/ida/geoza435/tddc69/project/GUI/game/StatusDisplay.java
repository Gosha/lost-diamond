package se.liu.ida.geoza435.tddc69.project.GUI.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import se.liu.ida.geoza435.tddc69.project.Observable;
import se.liu.ida.geoza435.tddc69.project.Observer;
import se.liu.ida.geoza435.tddc69.project.game.Game;
import se.liu.ida.geoza435.tddc69.project.game.Player;
import se.liu.ida.geoza435.tddc69.project.game.Token;

@SuppressWarnings("serial")
public class StatusDisplay extends JPanel implements Observer {

	JLabel label;
	JPanel panel;
	private Game game;

	public StatusDisplay(Game game) {
		this.game = game;
		setLayout(null);

		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		panel.setBounds(20, 20, 0, 0);

		label = new JLabel("NOT SET");
		label.setForeground(new Color(200, 200, 200));

		panel.add(label);

		panel.setBackground(new Color(0, 0, 0, 200));
		add(panel, BorderLayout.WEST);

		setOpaque(false);
		setVisible(true);

		for (Player p : game.getPlayers()) {
			p.observe(this);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		for (Component c : this.getComponents()) {
			if (c.contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void notifyChange(Observable observable) {
		updateDisplay();
	}

	private void updateDisplay() {
		String l = "";
		int i = 1;
		for (Player p : game.getPlayers()) {
			l += "Player " + i++;
			if (game.getCurrentPlayer() == p) {
				l += " *";
			}
			l += "<br>";
			l += "Money: " + p.getMoney() + "<br>";
			l += "Has: ";
			for (Token token : p.getTokens()) {
				l += token + " ";
			}
			l += "<br>";
		}
		l = "<html>" + l + "</html>";
		label.setText(l);
		panel.setSize(label.getPreferredSize());
		repaint();
	}

}

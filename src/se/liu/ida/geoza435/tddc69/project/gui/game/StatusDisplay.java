package se.liu.ida.geoza435.tddc69.project.gui.game;

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

/**
 * Displays status for all Players in text-format
 */
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
		label.setForeground(new Color(242, 242, 242));

		panel.add(label);

		panel.setBackground(new Color(0, 0, 0, 200));
		add(panel, BorderLayout.WEST);

		setOpaque(false);
		setVisible(true);

		for (Player p : game.getPlayers()) {
			p.observe(this);
		}
	}

	@SuppressWarnings("RefusedBequest")
	@Override
	public boolean contains(int x, int y) {
		for (Component component : this.getComponents()) {
			if (component.contains(x, y)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void notifyChange(Observable observable) {
		updateDisplay();
	}

	@SuppressWarnings({ "NonConstantStringShouldBeStringBuffer",
			"StringContatenationInLoop", "ObjectEquality" })
	private void updateDisplay() {
		String txt = "";
		for (Player p : game.getPlayers()) {
			txt += "Player " + p.getNum();
			if (game.getCurrentPlayer() == p) {
				txt += " *";
			}
			txt += "<br>";
			txt += "Money: " + p.getMoney() + "<br>";
			txt += "Has: ";
			for (Token token : p.getTokens()) {
				txt += token + " ";
			}
			txt += "<br>";
		}
		txt = "<html>" + txt + "</html>";
		label.setText(txt);
		panel.setSize(label.getPreferredSize());
		System.out.println(txt);
		repaint();
	}

}

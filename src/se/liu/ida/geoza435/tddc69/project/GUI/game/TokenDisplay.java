package se.liu.ida.geoza435.tddc69.project.GUI.game;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.game.Position;
import se.liu.ida.geoza435.tddc69.project.game.Token;

@SuppressWarnings("serial")
public class TokenDisplay extends JLabel {

	public TokenDisplay(Token token) {
		super(token.toString());
		Position position = token.getAt().getPosition();
		this.setBounds(0, 0, 100, 20);
		this.setLocation(position.getX(), position.getY());
	}

}

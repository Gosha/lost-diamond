package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Position;

public class ConnectionDisplay extends JComponent {
	Connection connection;

	public ConnectionDisplay(Connection c) {
		this.connection = c;
	}

	@Override
	public Rectangle getBounds(Rectangle rv) {
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();

		rv.setBounds(Math.min(a.getX(), b.getX()),
				Math.min(a.getY(), b.getY()),
				Math.abs(a.getX() - b.getX()),
				Math.abs(a.getY() - b.getY()));
		System.out.println(rv);
		return rv;
	}

	@Override
	public Dimension getPreferredSize() {
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();
		Dimension d = new Dimension(Math.abs(a.getX() - b.getX()),
				Math.abs(a.getY() - b.getY()));
		return d;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();

		System.out.println(getPreferredSize());

		g.drawLine(0, 0, this.getPreferredSize().width,
				this.getPreferredSize().height);
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("paint");
		this.paintComponent(g);
	}
}

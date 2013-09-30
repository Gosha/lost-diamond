package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.game.Connection;
import se.liu.ida.geoza435.tddc69.project.game.Position;

public class ConnectionDisplay extends JLabel {
	private static final long serialVersionUID = 1L;
	Connection connection;

	public ConnectionDisplay(Connection c) {
		this.connection = c;
		this.setBounds(boundsSet(new Rectangle()));
		this.setSize(sizeSet());
	}

	public Rectangle boundsSet(Rectangle rv) {
		/*
		 * TODO: Better name
		 */
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();

		rv.setBounds(Math.min(a.getX(), b.getX()),
				Math.min(a.getY(), b.getY()),
				Math.abs(a.getX() - b.getX()),
				Math.abs(a.getY() - b.getY()));
		System.out.println(rv);
		return rv;
	}

	public Dimension sizeSet() {
		/*
		 * TODO: Better name
		 */
		Position a = connection.getA().getPosition();
		Position b = connection.getB().getPosition();
		Dimension d = new Dimension(Math.abs(a.getX() - b.getX() + 20),
				Math.abs(a.getY() - b.getY()) + 20);
		return d;
	}

	@Override
	public void paintComponent(Graphics g) {
		/*
		 * TODO: Clean up
		 */
		super.paintComponent(g);
		Graphics2D g2d = DrawingTools.setupGraphics(g);

		// Position a = connection.getA().getPosition();
		// Position b = connection.getB().getPosition();

		System.out.println(sizeSet());

		BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL);
		g2d.setStroke(bs1);

		g2d.drawLine(0, 0, this.sizeSet().width,
				this.sizeSet().height);
	}

}

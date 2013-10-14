package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import se.liu.ida.geoza435.tddc69.project.game.Position;

public final class DrawingTools {

	private DrawingTools() {}

	public static Graphics2D setupGraphics(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		return g2d;
	}

	public static double pointToLineDistance(Point A, Point B, Point P) {
		double normalLength =
				Math.sqrt((B.x - A.x) * (B.x - A.x) + (B.y - A.y) * (B.y - A.y));
		return Math.abs(
				(P.x - A.x) * (B.y - A.y) - (P.y - A.y) * (B.x - A.x))
				/ normalLength;
	}

	public static boolean connectionFromBottom(Position a, Position b) {
		return a.getX() > b.getX() && a.getY() < b.getY()
				|| a.getX() < b.getX() && a.getY() > b.getY();
	}
}

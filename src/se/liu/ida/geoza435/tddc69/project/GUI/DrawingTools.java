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

	@SuppressWarnings("OverlyComplexArithmeticExpression")
	public static double pointToLineDistance(Point linePointA,
			Point linePointB, Point mousePoint) {
		double normalLength =
				Math.sqrt((linePointB.x - linePointA.x)
						* (linePointB.x - linePointA.x)
						+ (linePointB.y - linePointA.y)
						* (linePointB.y - linePointA.y));
		return Math.abs(
				(mousePoint.x - linePointA.x) * (linePointB.y - linePointA.y)
						- (mousePoint.y - linePointA.y)
						* (linePointB.x - linePointA.x))
				/ normalLength;
	}

	public static boolean isConnectionFromBottom(Position posa, Position posb) {
		return posa.getX() > posb.getX() && posa.getY() < posb.getY()
				|| posa.getX() < posb.getX() && posa.getY() > posb.getY();
	}
}

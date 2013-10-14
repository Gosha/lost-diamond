package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Position;

public class DragMotionListener extends MouseAdapter {

	protected Point anchorPoint;
	protected boolean overbearing;
	protected MarkDisplay md;

	public DragMotionListener(MarkDisplay md) {
		this.md = md;
	}

	public DragMotionListener() throws Exception {
		throw new Exception("Has to be created with a MarkDisplay");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO: Better names
		anchorPoint = e.getPoint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO: Better names
		int anchorX = anchorPoint.x;
		int anchorY = anchorPoint.y;

		Point parentOnScreen = md.getParent()
				.getLocationOnScreen();
		Point mouseOnScreen = e.getLocationOnScreen();
		Point position = new Point(
				mouseOnScreen.x - parentOnScreen.x - anchorX,
				mouseOnScreen.y - parentOnScreen.y - anchorY);

		md.setLocation(position);

		md.mark.setPosition(new Position(position.x,
				position.y));

		// Change Z-Buffer if it is "overbearing"
		if (overbearing) {
			md.getParent().setComponentZOrder(md, 0);
			// repaint();
		}
		md.getParent().getParent().repaint();
	}

}

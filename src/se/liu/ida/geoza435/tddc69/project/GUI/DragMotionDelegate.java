package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Point;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.game.Position;

public class DragMotionDelegate implements MouseListenerDelegate {

	@Override
	public void mouseMoved(MouseListenerInstance mli, MouseEvent e) {
		// TODO: Better names
		mli.anchorPoint = e.getPoint();
	}

	@Override
	public void mouseDragged(MouseListenerInstance mli, MouseEvent e) {
		// TODO: Better names
		int anchorX = mli.anchorPoint.x;
		int anchorY = mli.anchorPoint.y;

		Point parentOnScreen = mli.handle.getParent()
				.getLocationOnScreen();
		Point mouseOnScreen = e.getLocationOnScreen();
		Point position = new Point(mouseOnScreen.x
				- parentOnScreen.x -
				anchorX, mouseOnScreen.y - parentOnScreen.y
				- anchorY);
		mli.handle.setLocation(position);

		mli.handle.mark.setPosition(new Position(position.x,
				position.y));

		// Change Z-Buffer if it is "overbearing"
		if (mli.handle.overbearing) {
			mli.handle.getParent().setComponentZOrder(mli.handle, 0);
			// repaint();
		}
		mli.handle.getParent().getParent().repaint();

	}

}

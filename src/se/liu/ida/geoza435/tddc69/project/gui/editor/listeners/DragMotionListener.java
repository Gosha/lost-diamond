package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.game.Position;
import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;

/**
 * Moves {@link MarkDisplay}s when mouse is dragged. Also updates the Marks
 * position.
 */
@SuppressWarnings("RefusedBequest")
public class DragMotionListener extends MouseAdapter {

	protected Point anchorPoint = null;
	protected MarkDisplay markDisplay;

	public DragMotionListener(MarkDisplay markDisplay) {
		this.markDisplay = markDisplay;
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {
		anchorPoint = mouseEvent.getPoint();
	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		int anchorX = anchorPoint.x;
		int anchorY = anchorPoint.y;

		Point parentOnScreen = markDisplay.getParent()
				.getLocationOnScreen();
		Point mouseOnScreen = mouseEvent.getLocationOnScreen();
		Point position = new Point(
				mouseOnScreen.x - parentOnScreen.x - anchorX,
				mouseOnScreen.y - parentOnScreen.y - anchorY);

		markDisplay.setLocation(position);

		markDisplay.mark.setPosition(new Position(position.x,
				position.y));

		markDisplay.getParent().getParent().repaint();
	}

}

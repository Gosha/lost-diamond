package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import se.liu.ida.geoza435.tddc69.project.game.Mark;
import se.liu.ida.geoza435.tddc69.project.game.Position;

@SuppressWarnings("serial")
public class MarkDisplay extends JLabel {
	Mark mark;
	Rectangle bounds;
	protected Point anchorPoint;
	protected boolean overbearing;

	public final static int SIZE = 40;

	public MarkDisplay(Mark mark) {
		this.mark = mark;
		this.bounds = new Rectangle(
				mark.getPosition().getX(),
				mark.getPosition().getY(),
				SIZE, SIZE);
		this.setText(mark.toString());
		this.setBounds(bounds);
		this.setForeground(Color.BLUE);
		this.addDragListeners();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = DrawingTools.setupGraphics(g);
		// TODO Color constants, ugh
		g2d.setColor(new Color(200, 0, 0, 255));
		g2d.fillOval(0, 0, SIZE, SIZE);

		// Paint Label text / Other super stuff
		// super.paintComponent(g);
	}

	/**
	 * Add Mouse Motion Listener with drag function
	 */
	private void addDragListeners() {
		/**
		 * This handle is a reference to THIS because in next Mouse Adapter
		 * "this" is not allowed
		 */
		final MarkDisplay handle = this;
		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				anchorPoint = e.getPoint();
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int anchorX = anchorPoint.x;
				int anchorY = anchorPoint.y;

				Point parentOnScreen = getParent().getLocationOnScreen();
				Point mouseOnScreen = e.getLocationOnScreen();
				Point position = new Point(mouseOnScreen.x - parentOnScreen.x -
						anchorX, mouseOnScreen.y - parentOnScreen.y - anchorY);
				setLocation(position);

				handle.mark.setPosition(new Position(position.x, position.y));

				// Change Z-Buffer if it is "overbearing"
				if (overbearing) {
					getParent().setComponentZOrder(handle, 0);
					// repaint();
				}
				handle.getParent().getParent().repaint();
			}
		});
	}
}

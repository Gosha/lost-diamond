package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.event.MouseEvent;

public class SharedMouseMotionDelegate implements MouseListenerDelegate {

	static MouseListenerDelegate mld;

	public SharedMouseMotionDelegate() {
		if (mld == null) {
			mld = new DragMotionDelegate();
		}
	}

	@Override
	public void mouseMoved(MouseListenerInstance mli, MouseEvent e) {
		mld.mouseMoved(mli, e);
	}

	@Override
	public void mouseDragged(MouseListenerInstance mli, MouseEvent e) {
		mld.mouseDragged(mli, e);
	}

	public static void setMouseMotionDelegate(MouseListenerDelegate mld) {
		SharedMouseMotionDelegate.mld = mld;
	}

}

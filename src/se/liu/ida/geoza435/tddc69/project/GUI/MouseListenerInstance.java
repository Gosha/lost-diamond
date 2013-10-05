package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class MouseListenerInstance extends MouseAdapter {
	MarkDisplay handle;
	Point anchorPoint;
	MouseListenerHandler mlh;
	SharedMouseMotionDelegate mld;

	public MouseListenerInstance(MouseListenerHandler f, MarkDisplay j) {
		// TODO: Better names
		this.mlh = f;
		this.handle = j;
		this.mld = new SharedMouseMotionDelegate();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mld.mouseMoved(this, e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mld.mouseDragged(this, e);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Gör saker!
		JOptionPane.showMessageDialog(null, "Tja");
	}

}

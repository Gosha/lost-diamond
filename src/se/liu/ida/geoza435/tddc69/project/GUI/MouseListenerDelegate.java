package se.liu.ida.geoza435.tddc69.project.GUI;

import java.awt.event.MouseEvent;

public interface MouseListenerDelegate {

	public void mouseMoved(MouseListenerInstance mli, MouseEvent e);

	public void mouseDragged(MouseListenerInstance mli, MouseEvent e);
}

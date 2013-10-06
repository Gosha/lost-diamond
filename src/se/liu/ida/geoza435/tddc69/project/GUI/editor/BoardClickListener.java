package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class BoardClickListener extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Gör saker!
		JOptionPane.showMessageDialog(null, "Hej");

	}
}

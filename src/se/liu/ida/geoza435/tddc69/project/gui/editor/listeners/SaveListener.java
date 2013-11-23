package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.liu.ida.geoza435.tddc69.project.gui.BoardDisplay;

/**
 * Saves the Board to a file when the Save button is pressed and a file is
 * chosen.
 */
public class SaveListener implements ActionListener {

	BoardDisplay bd;

	public SaveListener(BoardDisplay boardDisplay) {
		this.bd = boardDisplay;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JFileChooser fChooser = new JFileChooser();
		FileFilter fFilter = new FileNameExtensionFilter("Board files", "dat");
		fChooser.setFileFilter(fFilter);

		int returnStatus = fChooser.showSaveDialog(bd.getParent());

		if (returnStatus == JFileChooser.APPROVE_OPTION) {
			try {
				FileOutputStream fostream = new FileOutputStream(
						fChooser.getSelectedFile());

				try (ObjectOutputStream oostream = new ObjectOutputStream(
						fostream)) {
					oostream.writeObject(bd.getBoard());
				}

				fostream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

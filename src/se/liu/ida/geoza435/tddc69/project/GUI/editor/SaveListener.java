package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;

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

		FileOutputStream fostream;
		ObjectOutputStream oostream;

		if (returnStatus == JFileChooser.APPROVE_OPTION) {
			try {
				fostream = new FileOutputStream(
						fChooser.getSelectedFile());

				oostream = new ObjectOutputStream(fostream);
				oostream.writeObject(bd.getBoard());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

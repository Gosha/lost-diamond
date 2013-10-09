package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;
import se.liu.ida.geoza435.tddc69.project.game.Board;

public class LoadListener implements ActionListener {

	BoardDisplay bd;
	MouseListenerHandler mlh;

	public LoadListener(BoardDisplay bd, MouseListenerHandler mlh) {
		this.bd = bd;
		this.mlh = mlh;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fChooser = new JFileChooser();
		FileFilter fFilter = new FileNameExtensionFilter("Board files", "dat");
		fChooser.setFileFilter(fFilter);

		int returnStatus = fChooser.showOpenDialog(bd.getParent());

		FileInputStream fistream;
		ObjectInputStream oistream;

		if (returnStatus == JFileChooser.APPROVE_OPTION) {
			try {
				fistream = new FileInputStream(fChooser.getSelectedFile());
				oistream = new ObjectInputStream(fistream);

				Board board = (Board) oistream.readObject();

				bd.clearBoard();
				bd.setBoard(board);
				bd.loadBoard();
				mlh.reenterState();
				bd.repaint();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
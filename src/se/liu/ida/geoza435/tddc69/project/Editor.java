package se.liu.ida.geoza435.tddc69.project;

import se.liu.ida.geoza435.tddc69.project.gui.editor.EditorController;

/**
 * Initializes the editor defined in {@link EditorController}
 */
public final class Editor {

	private Editor() {}

	public static void main(String[] args) {
		EditorController editorController = new EditorController();
		editorController.start();
	}

}

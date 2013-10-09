package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.ConnectionDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class TypeState extends AbstractEditorState {

	public TypeState(EditorView container, JButton button) {
		super(container, button);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {
		super.enterState(mlh);
		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseListener(new MarkTypeListener(md));
			md.addMouseMotionListener(new MouseOverListener(md));
		}
		for (ConnectionDisplay cd : mlh.getConnectionDisplays()) {
			cd.addMouseListener(new ConnectionTypeListener(cd));
			cd.addMouseMotionListener(new MouseOverListener(cd));
		}
	}

}

package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import javax.swing.JButton;

import se.liu.ida.geoza435.tddc69.project.GUI.BoardDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.GUI.MouseListenerHandler;

public class AddState extends AbstractEditorState {

	public AddState(EditorView container, JButton button) {
		super(container, button);
	}

	@Override
	public void enterState(MouseListenerHandler mlh) {
		super.enterState(mlh);
		BoardDisplay bd = mlh.getBoardDisplay();
		bd.addMouseListener(new AddListener(bd));

		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseListener(new SelectListener(md, bd));
			md.addMouseMotionListener(new MouseOverListener(md));
		}
	}

	@Override
	public void leaveState(MouseListenerHandler mlh) {
		BoardDisplay bd = mlh.getBoardDisplay();
		bd.selectNone();
		super.leaveState(mlh);
	}

}

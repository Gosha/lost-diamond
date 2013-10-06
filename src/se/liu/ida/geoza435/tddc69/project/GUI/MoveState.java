package se.liu.ida.geoza435.tddc69.project.GUI;

public class MoveState implements MouseHandlerState {

	@Override
	public void setupState(MouseListenerHandler mlh) {
		mlh.getBoardDisplay().addMouseListener(new BoardClickListener());
		for (MarkDisplay md : mlh.getMarkDisplays()) {
			md.addMouseMotionListener(new DragMotionListener(md));
		}
	}

}

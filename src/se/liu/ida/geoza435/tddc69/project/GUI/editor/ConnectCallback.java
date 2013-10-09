package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;
import se.liu.ida.geoza435.tddc69.project.game.Connection;

public class ConnectCallback implements SelectCallback {

	@Override
	public boolean run(SelectListener from) {
		MarkDisplay md;

		if ((md = from.bd.getSelectedMark()) != null) {
			if (md != from.md) {
				from.bd.addNewConnectionDisplay(new Connection(md.mark,
						from.md.mark));
			}
			from.bd.selectNone();
			from.bd.repaint();
			return false;
		} else {
			return true;
		}
	}

}

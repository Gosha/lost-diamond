package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;
import se.liu.ida.geoza435.tddc69.project.gui.ConnectionDisplay;

/**
 * Changes type of a Connection when mouseClicked
 * */
@SuppressWarnings("RefusedBequest")
public class ConnectionTypeListener extends MouseAdapter {

	ConnectionDisplay cd;

	public ConnectionTypeListener(ConnectionDisplay cd) {
		this.cd = cd;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		ConnectionType type = cd.getConnection().getType();
		ConnectionType[] vals = ConnectionType.values();
		cd.getConnection().setType(
				vals[(type.ordinal() + 1) % vals.length]);
		cd.repaint();
	}

}

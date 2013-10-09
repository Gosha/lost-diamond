package se.liu.ida.geoza435.tddc69.project.GUI.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import se.liu.ida.geoza435.tddc69.project.GUI.ConnectionDisplay;
import se.liu.ida.geoza435.tddc69.project.game.ConnectionType;

public class ConnectionTypeListener extends MouseAdapter {

	ConnectionDisplay cd;

	public ConnectionTypeListener(ConnectionDisplay cd) {
		this.cd = cd;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		ConnectionType type = cd.getConnection().getType();
		ConnectionType vals[] = ConnectionType.values();
		cd.getConnection().setType(
				vals[(type.ordinal() + 1) % vals.length]);
		cd.repaint();
	}

}

package se.liu.ida.geoza435.tddc69.project.game;

import java.io.Serializable;

/**
 * Connects two {@link Mark}s.
 * 
 * Positional data is stored in the two Marks the connection connects.
 */
// Already serialized
@SuppressWarnings("StandardVariableNames")
public class Connection implements Serializable {
	private static final long serialVersionUID = 1L;
	private Mark a, b;
	private ConnectionType type;

	public Connection(Mark a, Mark b, ConnectionType type) {
		this.a = a;
		this.b = b;
		this.type = type;
		a.addConnection(this);
		b.addConnection(this);
	}

	public Connection(Mark a, Mark b) {
		this(a, b, ConnectionType.normal);
	}

	public Mark getA() {
		return a;
	}

	public Mark getB() {
		return b;
	}

	public ConnectionType getType() {
		return type;
	}

	public void setType(ConnectionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "[c:#" + a.hashCode() + "<->#" + b.hashCode() + ", t=" + type
				+ "]";
	}
}

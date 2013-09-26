package se.liu.ida.geoza435.tddc69.project.game;

public class Connection {
	Mark a, b;
	ConnectionType type;

	public Connection(Mark a, Mark b, ConnectionType type) {
		this.a = a;
		this.b = b;
		this.type = type;
	}

	public Connection(Mark a, Mark b) {
		this(a, b, ConnectionType.normal);
	}

	public Mark getA() {
		return a;
	}

	public void setA(Mark a) {
		this.a = a;
	}

	public Mark getB() {
		return b;
	}

	public void setB(Mark b) {
		this.b = b;
	}

	public ConnectionType getType() {
		return type;
	}

	public void setType(ConnectionType type) {
		this.type = type;
	}
}

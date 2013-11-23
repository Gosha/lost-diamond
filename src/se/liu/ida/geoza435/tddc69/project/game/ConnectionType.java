package se.liu.ida.geoza435.tddc69.project.game;

/**
 * Defines how a Connection looks and what rules apply.
 */
// Already serialized and hence I can't change the enums names to uppercase
public enum ConnectionType {
	/** Normal connections, no special rules */
	normal,
	/** Flight connections, red and requires money */
	flight,
	/** Boat connections, blue and requires money */
	boat
}

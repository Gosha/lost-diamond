package se.liu.ida.geoza435.tddc69.project.game;

/**
 * Defines how a Mark looks and what rules apply.
 */
// Already serialized and hence I can't change the names to uppercase
public enum MarkType {
	/** Normal mark, no special rules */
	normal,
	/** Starting mark, players start and finish here */
	start,
	/** Boat mark, players may pay to go by boat over these */
	boat,
	/**
	 * City mark, tokens may reside on these and are connectionpoints for
	 * flights
	 */
	city
}

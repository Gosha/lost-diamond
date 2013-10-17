package se.liu.ida.geoza435.tddc69.project;

/**
 * A simple Observer/Observable Pattern implementation.
 * 
 * A {@link Observable} abstract class is defined, too.
 */
public interface Observer {
	void notifyChange(Observable observable);
}

package se.liu.ida.geoza435.tddc69.project.GUI;

/**
 * State Pattern interface for the MouseHandler
 * 
 * @see MouseListenerHandler
 */
public interface MouseHandlerState {

	void enterState(MouseListenerHandler mouseListenerHandler);

	void leaveState(MouseListenerHandler mouseListenerHandler);

}

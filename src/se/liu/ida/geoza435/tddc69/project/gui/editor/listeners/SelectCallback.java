package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;

/**
 * Trying out using callbacks instead of subclasses.
 * 
 * Only used in {@link ConnectCallback}
 */
public interface SelectCallback {
	// I'm quite certain "did" could be interpreted as a question word.
	public boolean didRun(SelectListener from);
}

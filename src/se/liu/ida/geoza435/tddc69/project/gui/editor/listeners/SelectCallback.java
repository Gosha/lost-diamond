package se.liu.ida.geoza435.tddc69.project.gui.editor.listeners;


/**
 * Trying out using callbacks instead of subclasses.
 * 
 * Only used in {@link ConnectCallback}
 */
public interface SelectCallback {
	@SuppressWarnings("BooleanMethodNameMustStartWithQuestion")
	public boolean run(SelectListener from);
}

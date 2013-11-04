package se.liu.ida.geoza435.tddc69.project.gui.game;

import se.liu.ida.geoza435.tddc69.project.gui.MarkDisplay;

/**
 * Container for a Synchronized MarkDisplay. Called from {@link GUIPlayer} and
 * {@link MarkClickListener}.
 * 
 * Required because MarkDisplays are set from {@link MarkClickListener} in the
 * Swing thread while the Game Loop thread waits for a response.
 */
@SuppressWarnings({ "WaitNotInLoop", "WaitOrAwaitWithoutTimeout" })
public class ClickedMarkDisplay {
	private MarkDisplay markDisplay = null;

	public void waitUntilSet() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setMarkDisplay(MarkDisplay markDisplay) {
		synchronized (this) {
			this.markDisplay = markDisplay;
			this.notifyAll();
		}
	}

	public MarkDisplay getMarkDisplay() {
		return markDisplay;
	}

}

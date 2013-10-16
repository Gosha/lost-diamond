package se.liu.ida.geoza435.tddc69.project.GUI.game;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;

@SuppressWarnings({ "WaitNotInLoop", "WaitOrAwaitWithoutTimeout" })
public class ClickedMarkDisplay {
	private MarkDisplay markDisplay = null;

	public void waitUntilSet() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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

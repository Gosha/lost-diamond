package se.liu.ida.geoza435.tddc69.project.GUI.game;

import se.liu.ida.geoza435.tddc69.project.GUI.MarkDisplay;

public class ClickedMarkDisplay {
	private MarkDisplay markDisplay;

	public MarkDisplay waitUntilSet() {
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.markDisplay;
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

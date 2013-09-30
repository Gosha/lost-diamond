package se.liu.ida.geoza435.tddc69.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
	List<Observer> observers;

	public Observable() {
		this.observers = new ArrayList<Observer>();
	}

	public void observe(Observer observer) {
		this.observers.add(observer);
	}

	protected void changed() {
		for (Observer observer : this.observers) {
			observer.notifyChange(this);
		}
	}
}

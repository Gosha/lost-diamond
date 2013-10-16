package se.liu.ida.geoza435.tddc69.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("AbstractClassWithoutAbstractMethods")
public abstract class Observable {
	private List<Observer> observers;

	protected Observable() {
		this.observers = Collections
				.synchronizedList(new ArrayList<Observer>());
	}

	public synchronized void observe(Observer observer) {
		this.observers.add(observer);
	}

	protected synchronized void changed() {
		for (Observer observer : this.observers) {
			observer.notifyChange(this);
		}
	}
}

package javapatterns.observerpattern;

import java.util.ArrayList;

/**
 * Observer pattern is based on the inversion of control paradigm.
 * It should be used when one or more objects have to execute a method when an event occurs 
 * but they are not able to directly capture the event.
 * The events receiver object (the Caller) trace the object that are interested in the events captured 
 * (the listeners) and calls their callback method.
 * Listeners should implement an interface to allow registration of different objects.
 * 
 * Notice difference between Observer and Callback OO design patterns:
 *  - callback : notifies a single caller that some operation finished with some result
 *  - observer : notifies zero to n interested parties that some event (for example a finished operation) happened
 * 
 * @author gloria
 *
 */

public class Caller {
	
	ArrayList<Listener> listeners;
	
	public Caller() {
		listeners = new ArrayList<Listener>();
	}
	
	public void registerListener(Listener listener) {
		listeners.add(listener);
	}
	
	public void notifiySomethingHappened() {
		listeners.forEach(l -> l.callback());
	}
	
	public static void main(String[] args) {
		Caller caller = new Caller();
		ListenerImpl listener = new ListenerImpl();
		AlternativeListenerImpl altListener = new AlternativeListenerImpl();
		caller.registerListener(listener);
		altListener.listenCaller(caller);
		
		System.out.println("Caller invoked");
		caller.notifiySomethingHappened();
	}

}

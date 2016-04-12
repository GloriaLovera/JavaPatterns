package javapatterns.callbackpattern;

import java.util.ArrayList;

/**
 * Callback pattern (also named observer pattern) is based on the inversion of control paradigm.
 * It should be used when one or more objects have to execute a method when an event occurs 
 * but they are not able to directly capture the event.
 * The events receiver object (the Caller) trace the object that are interested in the events captured 
 * (the listeners) and calls their callback method.
 * Listeners should implement an interface to allow registration of different objects.
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

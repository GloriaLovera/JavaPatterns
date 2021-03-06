package javapatterns.callbackpattern;


/**
 * Callback pattern is based on the inversion of control paradigm.
 * It should be used when one has to execute a method when 
 * the result of another object asynchronous method is available.
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
	
	public Caller() {}
	
	public void notifiySomethingHappened(Listener listener) {
		String result = "Asynch work result";
		listener.callback(result);
	}
	
	public static void main(String[] args) {
		Caller caller = new Caller();
		ListenerImpl listener = new ListenerImpl();
		
		System.out.println("Caller invoked");
		caller.notifiySomethingHappened(listener);
	}

}

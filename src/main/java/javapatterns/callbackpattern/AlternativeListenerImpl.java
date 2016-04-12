package javapatterns.callbackpattern;

public class AlternativeListenerImpl implements Listener{
	
	@Override
	public void callback() {
		System.out.println("AlternativeListenerImpl callback executed");
	}
	
	public void listenCaller(Caller caller) {
		caller.registerListener(this);
	}

}

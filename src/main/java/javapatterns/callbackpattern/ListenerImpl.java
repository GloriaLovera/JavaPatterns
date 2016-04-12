package javapatterns.callbackpattern;

public class ListenerImpl implements Listener {

	public void callback(String result) {
		System.out.println("ListenerImpl callback executed. Result received: " + result);
	}

}

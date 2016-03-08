package JavaPatterns.javapatterns.statepattern;

/**
 * State Pattern is used to implement the transaction of a property
 * which behavior can be modeled using a state machine, 
 * to avoid multiple if statements.
 * An inner class is created for each status to be modeled.
 * 
 * This simple example shows how it's possible to implement the status 
 * transactions of a Device. Possible status: turnedOn and turnedOff.
 * A basic implementation realizes the methods turnOn() and turnOff()
 * using something like that:
 * 
 * 	  public void turnOn() {
 * 		if (status.equals("OFF")) {
 * 			status = "OFF";
 *      } //else do_nothing
 *    }
 *    
 *    public void turnOff() {
 * 		if (status.equals("ON")) {
 * 			status = "ON";
 *      } //else do_nothing
 *    }
 *    
 * Notice that in case of multiple states the if statements become 
 * more and more complicated, affecting readability.
 * 
 * @author glovera
 *
 */

public class Device {
	
	private Status status = new TurnedOff();
	
	@Override
	public String toString() {
		String currentStatus = status.isTurnedOn() ? " turned ON" : " turned OFF";
		return "Device is" + currentStatus;
	}
	
	public void turnOn() {
		status.turnOn();
		whichStatusObj();
	}
	
	public void turnOff() {
		status.turnOff();
		whichStatusObj();
	}
	
	/**
	 * This method is implemented just to highlight 
	 * the status instance changes in the main.
	 */
	private void whichStatusObj() {
		String statusType = (status instanceof TurnedOn) ? 
				TurnedOn.class.getSimpleName() :
				TurnedOff.class.getSimpleName();
		System.out.println("Status is now an instance of " + statusType);
	}
	
	/**
	 * Interface to be implemented by the inner classes
	 * representing the possible status of the object.
	 * 
	 * @author gloria
	 *
	 */
	private interface Status {
		abstract void turnOn();
		abstract void turnOff();
		abstract boolean isTurnedOn();
	}
	
	private class TurnedOn implements Status {
		
		public void turnOn() {}
		
		public void turnOff() {
			status = new TurnedOff();
		}
		
		public boolean isTurnedOn() {
			return true;
		}
	}
	
	private class TurnedOff implements Status {
		
		public void turnOn() {
			status = new TurnedOn();
		}
		
		public void turnOff() {}
		
		public boolean isTurnedOn() {
			return false;
		}
	}
	
	/**
	 * Main method to test the class
	 */
	public static void main(String[] args) {
		Device myDevice = new Device();
		
		System.out.println(myDevice);
		myDevice.turnOn();
		
		System.out.println(myDevice);
		myDevice.turnOff();
		
		System.out.println(myDevice);
	}

}

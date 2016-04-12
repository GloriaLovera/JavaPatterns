package javapatterns.statepattern;

/**
 * enum can be used instead of state pattern proposed in Device class.
 *  
 * @author gloria
 *
 */

public class AlternativeDevice{
	private Status status = Status.OFF;
	
	@Override
	public String toString() {
		return "Device is " + status.toString();
	}
	
	public void turnOn() {
		status = status.turnOn();
	}
	
	public void turnOff() {
		status = status.turnOff();
	}
	
	private enum Status {
		ON("turned ON") {
			Status turnOn() {
				return this;
			}
			
			Status turnOff() {
				System.out.println("Turning off...");
				return Status.OFF;
			}
			
			boolean isTurnedOn() {
				return true;
			}
		},
		OFF("turned OFF") {
			Status turnOn() {
				System.out.println("Turning on...");
				return ON;
			}
			
			Status turnOff() {
				return this;
			}
			
			boolean isTurnedOn() {
				return false;
			}
		};
		
		private String description;
		
		private Status(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return description;
		}
		
		abstract Status turnOn();
		
		abstract Status turnOff();
		
		abstract boolean isTurnedOn();
	}
	
	/**
	 * Main method to test the class
	 */
	public static void main(String[] args) {
		AlternativeDevice myDevice = new AlternativeDevice();
		
		System.out.println(myDevice);
		myDevice.turnOn();
		
		System.out.println(myDevice);
		myDevice.turnOff();
		
		System.out.println(myDevice);
	}

}

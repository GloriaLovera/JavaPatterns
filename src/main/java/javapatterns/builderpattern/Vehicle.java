package javapatterns.builderpattern;


/**
 * Builder design pattern is used in case of complex object
 * to avoid constructor with too many arguments and huge overloading
 * to manage optional field.
 * Creating a builder inner class, the logic to initialize an object can be
 * grouped in that class (e.g. providing default values).
 * An instance can only be created through its builder.
 * 
 * @author gloria
 *
 */
public class Vehicle {
	
	private VehicleType vtype;
	private int wheelNumber;
	private String plate;
	private String brand;
	private int registration;
	private String proprietaryId;
	private String model;
	
	public static Builder with() {
		return new Builder();
	}
	
	public static class Builder {
		
		private VehicleType vtype = VehicleType.MOTORCYCLE;
		private int wheelNumber = 2;
		private String plate = "";
		private String brand = "";
		private int registration = -1;
		private String proprietaryId = "";
		private String model = "";
		
		private Builder() {}
		
		public Vehicle.Builder vtype(VehicleType vtype) {
			this.vtype = vtype;
			return this;
		}
		public Vehicle.Builder wheelNumber(int wheelNumber) {
			this.wheelNumber = wheelNumber;
			return this;
		}
		public Vehicle.Builder plate(String plate) {
			this.plate = plate;
			return this;
		}
		public Vehicle.Builder brand(String brand) {
			this.brand = brand;
			return this;
		}
		public Vehicle.Builder registration(int registration) {
			this.registration = registration;
			return this;
		}
		public Vehicle.Builder proprietaryId(String proprietaryId) {
			this.proprietaryId = proprietaryId;
			return this;
		}
		public Vehicle.Builder model(String model) {
			this.model = model;
			return this;
		}
		
		public Vehicle build() {
			return new Vehicle(this);
		}
		
	}
	
	private Vehicle(Builder builder) {
		
		this.vtype = builder.vtype;
		this.wheelNumber = builder.wheelNumber;
		this.plate = builder.plate;
		this.brand = builder.brand;
		this.registration = builder.registration;
		this.proprietaryId = builder.proprietaryId;
		this.model = builder.model;
	}

	public VehicleType getVtype() {
		return vtype;
	}

	public int getWheelNumber() {
		return wheelNumber;
	}

	public String getPlate() {
		return plate;
	}

	public String getBrand() {
		return brand;
	}

	public int getRegistration() {
		return registration;
	}

	public String getProprietaryId() {
		return proprietaryId;
	}

	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vtype=" + vtype + ", wheelNumber=" + wheelNumber
				+ ", plate=" + plate + ", brand=" + brand + ", registration="
				+ registration + ", proprietaryId=" + proprietaryId
				+ ", model=" + model + "]";
	}

	public static void main(String[] args) {
		System.out.println(
				Vehicle.with()
				.vtype(VehicleType.CAR)
				.brand("AUDI")
				.model("A3")
				.wheelNumber(4)
				.registration(2005)
				.plate("DD243KJ")
				.proprietaryId("LVRGLR88d54F725J")
				.build()
				);
	}
	
}

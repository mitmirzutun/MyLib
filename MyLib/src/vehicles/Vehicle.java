package vehicles;

public abstract class Vehicle {
	private int numOfWheels, passengers, numOfDoors, maxSpeed,curSpeed,accelaration;
	private double maxFuel, curFuel, fuelConsumption;
	public Vehicle(int numOfWheels, int passengers, int numOfDoors, int maxSpeed, int accelaration, double maxFuel, double fuelConsumption) {
		this.numOfWheels=numOfWheels;
		this.passengers=passengers;
		this.numOfDoors=numOfDoors;
		this.maxSpeed=maxSpeed;
		this.curSpeed=0;
		this.accelaration=accelaration;
		this.maxFuel=maxFuel;
		this.curFuel=0;
		this.fuelConsumption=fuelConsumption;
	}
	public void accelarate(double time) {
		
	}
}

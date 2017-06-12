package model;

public class Suv extends Vehicle{

	private double cost;

	public Suv(String licensePLate, String color, double cost) {
		super(licensePLate,color);
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Suv [cost=" + cost + "]";
	}
	
	
	
}

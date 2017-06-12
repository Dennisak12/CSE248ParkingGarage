package model;

public class ParkingGarage {

	private int numOfSpaces;
	private int numOfLevels;
	private int numOfHandicapped;
	private int numOfVip;

	public ParkingGarage(int numOfSpaces, int numOfLevels, int numOfHandicapped, int numOfVip) {
		super();
		this.numOfSpaces = numOfSpaces;
		this.numOfLevels = numOfLevels;
		this.numOfHandicapped = numOfHandicapped;
		this.numOfVip = numOfVip;
	}

	public int getNumOfSpaces() {
		return numOfSpaces;
	}

	public void setNumOfSpaces(int numOfSpaces) {
		this.numOfSpaces = numOfSpaces;
	}

	public int getNumOfLevels() {
		return numOfLevels;
	}

	public void setNumOfLevels(int numOfLevels) {
		this.numOfLevels = numOfLevels;
	}

	public int getNumOfHandicapped() {
		return numOfHandicapped;
	}

	public void setNumOfHandicapped(int numOfHandicapped) {
		this.numOfHandicapped = numOfHandicapped;
	}

	public int getNumOfVip() {
		return numOfVip;
	}

	public void setNumOfVip(int numOfVip) {
		this.numOfVip = numOfVip;
	}

	@Override
	public String toString() {
		return "ParkingGarage [numOfSpaces=" + numOfSpaces + ", numOfLevels=" + numOfLevels + ", numOfHandicapped="
				+ numOfHandicapped + ", numOfVip=" + numOfVip + "]";
	}

}

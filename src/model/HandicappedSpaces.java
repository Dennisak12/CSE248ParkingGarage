package model;

import java.util.ArrayList;

public class HandicappedSpaces {

	private int counter = 0;
	private ArrayList<String> handicappedSpace = new ArrayList<String>();

	public HandicappedSpaces(int counter) {
		this.counter = counter;
	}

	public void addVehicle(String v) {
		if (counter > 4) {
			System.out.println("The garage is full");
		} else {
			handicappedSpace.add(v);
			counter++;
		}
	}

	public boolean removeVehicle(String s) {
		for(int i = 0; i < counter; i++){
			if(handicappedSpace.contains(s)){
				handicappedSpace.remove(s);
				counter--;
				return true;
			}
		}
		System.out.println("not found in handicapped list");
		return false;
	}
	
	public boolean isFound(String s) {
		for (int i = 0; i > counter; i++) {
			if (handicappedSpace.contains(s)) {
				System.out.println(s + " found in regular spaces list");
				return true;
			}
		}
		System.out.println("not found in regular spaces list");
		return false;
	}
	
	public boolean isFullHandi(){
		if (counter > 5) {
			System.out.println("The garage is full");
			return true;
		} else {
			return false;
		}
	}

	public void printStoredSpaces() {
		System.out.println("HANDICAPPED SPACES (only stores 5 spots)---- LicensePlate:" + handicappedSpace);
		System.out.println("---------------------------------------------------------");
	}

}

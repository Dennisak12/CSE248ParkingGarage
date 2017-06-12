package model;

import java.util.ArrayList;

public class VipSpaces {

	private int counter = 0;
	private ArrayList<String> vipSpace = new ArrayList<String>();

	public VipSpaces(int counter) {
		this.counter = counter;
	}

	public void addVehicle(String v) {
		if (counter > 4) {
			System.out.println("Garage is full");
		} else {
			vipSpace.add(v);
			counter++;
		}
	}

	public boolean removeVehicle(String s) {
		for(int i = 0; i < counter; i++){
			if(vipSpace.contains(s)){
				System.out.println("found in vip spaces list");
				vipSpace.remove(s);
				counter--;
				return true;
			}
		}
		System.out.println("not found in vip spaces list");
		return false;
	}
	
	public boolean isFullVip(){
		if (counter > 5) {
			System.out.println("The garage is full");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFound(String s) {
		for (int i = 0; i > counter; i++) {
			if (vipSpace.contains(s)) {
				System.out.println(s + " found in regular spaces list");
				return true;
			}
		}
		System.out.println("not found in regular spaces list");
		return false;
	}

	public void printStoredSpaces() {
		System.out.println("VIP SPACES (only stores 5 spots) ---- LicensePlate:" + vipSpace);
	}

}

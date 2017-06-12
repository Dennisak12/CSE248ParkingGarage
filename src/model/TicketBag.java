package model;

import java.util.ArrayList;

public class TicketBag {

	private int counter = 0;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

	public TicketBag(Ticket ticket) {
		this.tickets = tickets;
	}

	public void addTicket(Ticket t) {
			tickets.add(t);
			counter++;
	}

	public boolean removeTicket(String s) {
		for(int i = 0; i < counter; i++){
			if(tickets.contains(s)){
				System.out.println("found Ticket");
				tickets.remove(s);
				return true;
			}
		}
		System.out.println("not found in This ticket bag");
		return false;
	}
	
	public boolean isFound(String s) {
		for (int i = 0; i > counter; i++) {
			if (tickets.contains(s)) {
				System.out.println(s + "found in ticket bag");
				return true;
			}
		}
		System.out.println("not found in ticket bag");
		return false;
	}

	public void printStoredSpaces() {
		System.out.println("Tickets in the bag: " + tickets);
	}

	
	
}

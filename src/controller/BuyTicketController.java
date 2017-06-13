package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Car;
import model.HandicappedSpaces;
import model.RegularSpaces;
import model.Suv;
import model.Ticket;
import model.TicketBag;
import model.Truck;
import model.VipSpaces;
import view.BuyTicketPane;
import view.StartPane;

public class BuyTicketController {

	public double suvCost = 2.0;
	private double truckCost = 3.0;
	private double carCost = 1.0;
	private double regularSpaceCost = 10.0;
	private double vipSpaceCost = 50.0;
	private double handicappedCost = 15.0;
	private double costOfBill;
	private int counter = 1;

	public BuyTicketController(StartPane startPane, BuyTicketPane buyTicketPane, HandicappedSpaces handiSpaces,
			RegularSpaces regularSpaces, VipSpaces vipSpaces, TicketBag ticketBag, Stage mainStage) {

		buyTicketPane.getOrderTicket().setOnAction(e -> {
			isFull(handiSpaces, regularSpaces, vipSpaces);
			checkVehicle(buyTicketPane, handiSpaces, regularSpaces, vipSpaces);
			alertBill(buyTicketPane, handiSpaces, regularSpaces, vipSpaces,ticketBag);
			vipSpaces.printStoredSpaces();
			regularSpaces.printStoredSpaces();
			handiSpaces.printStoredSpaces();

			mainStage.setScene(startPane.getScene());
			mainStage.show();
			

		});

		// takes the user to the start menu
		buyTicketPane.getExitButton().setOnAction(e -> {
			mainStage.setScene(startPane.getScene());
			mainStage.show();
		});

	}

	public void checkVehicle(BuyTicketPane buyTicketPane, HandicappedSpaces handiSpace, RegularSpaces regularSpace,
			VipSpaces vipSpace) {
		if (buyTicketPane.getCombo1().getValue() == "CAR") {
			createCar(buyTicketPane, handiSpace, regularSpace, vipSpace);
		} else if (buyTicketPane.getCombo1().getValue() == "SUV") {
			createSuv(buyTicketPane, handiSpace, regularSpace, vipSpace);
		} else if (buyTicketPane.getCombo1().getValue() == "TRUCK") {
			createTruck(buyTicketPane, handiSpace, regularSpace, vipSpace);
		}
	}

	public void checkParkingSpace(BuyTicketPane buyTicketPane, HandicappedSpaces handiSpace, RegularSpaces regularSpace,
			VipSpaces vipSpace) {
		if (buyTicketPane.getCombo3().getValue() == "Handicapped Space") {
			checkVehicle(buyTicketPane, handiSpace, regularSpace, vipSpace);
		} else if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			checkVehicle(buyTicketPane, handiSpace, regularSpace, vipSpace);
		} else if (buyTicketPane.getCombo3().getValue() == "VIP Space") {
			checkVehicle(buyTicketPane, handiSpace, regularSpace, vipSpace);
		}
	}

	public void createCar(BuyTicketPane buyTicketPane, HandicappedSpaces handiSpace, RegularSpaces regularSpace,
			VipSpaces vipSpace) {

		isFull(handiSpace, regularSpace, vipSpace);
		Car c = new Car(buyTicketPane.getLicensePlate(), buyTicketPane.getColorField(), carCost);
		if (buyTicketPane.getCombo3().getValue() == "VIP Space") {
			vipSpace.addVehicle(c.getLicensePLate());
		} else if (buyTicketPane.getCombo3().getValue() == "Handicapped Space") {
			handiSpace.addVehicle(c.getLicensePLate());
		} else if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			regularSpace.addVehicle(c.getLicensePLate());
		}
	}

	public void createSuv(BuyTicketPane buyTicketPane, HandicappedSpaces handiSpace, RegularSpaces regularSpace,
			VipSpaces vipSpace) {

		Suv v = new Suv(buyTicketPane.getLicensePlate(), buyTicketPane.getColorField(), suvCost);
		if (buyTicketPane.getCombo3().getValue() == "VIP Space") {
			vipSpace.addVehicle(v.getLicensePLate());
		} else if (buyTicketPane.getCombo3().getValue() == "Handicapped Space") {
			handiSpace.addVehicle(v.getLicensePLate());
		} else if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			regularSpace.addVehicle(v.getLicensePLate());
		}
	}

	public void createTruck(BuyTicketPane buyTicketPane, HandicappedSpaces handiSpace, RegularSpaces regularSpace,
			VipSpaces vipSpace) {

		isFull(handiSpace, regularSpace, vipSpace);
		Truck t = new Truck(buyTicketPane.getLicensePlate(), buyTicketPane.getColorField(), truckCost);
		if (buyTicketPane.getCombo3().getValue() == "VIP Space") {
			vipSpace.addVehicle(t.getLicensePLate());
		} else if (buyTicketPane.getCombo3().getValue() == "Handicapped Space") {
			handiSpace.addVehicle(t.getLicensePLate());
		} else if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
			regularSpace.addVehicle(t.getLicensePLate());
		}

	}

	public boolean isFull(HandicappedSpaces handiSpace, RegularSpaces regularSpace, VipSpaces vipSpace) {
		if (regularSpace.isFullRegular() == true) {
			alertWarning();

		} else if (handiSpace.isFullHandi() == true) {
			alertWarning();

		} else if (vipSpace.isFullVip() == true) {
			alertWarning();
		}
		return false;
	}

	public void alertWarning() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("OOPS");
		alert.setContentText("There are not enough regular spaces in the garage, please try again later");
		alert.showAndWait();
	}

	public boolean alertBill(BuyTicketPane buyTicketPane, HandicappedSpaces handiSpace, RegularSpaces regularSpace,
			VipSpaces vipSpace, TicketBag ticketBag) {

		costOfBill = 0;
		if (handiSpace.isFullHandi()) {
			Alert uraDambess = new Alert(AlertType.ERROR);
			uraDambess.setContentText("UR A DUMBASS");
			uraDambess.showAndWait();
			return true;
		} else {

			if (buyTicketPane.getCombo1().getValue() == "CAR") {
				costOfBill = costOfBill + (carCost * 2);
			} else if (buyTicketPane.getCombo1().getValue() == "SUV") {
				costOfBill = costOfBill + (suvCost * 2);
			} else if (buyTicketPane.getCombo1().getValue() == "TRUCK") {
				costOfBill = costOfBill + (truckCost * 2);
			}
			if (buyTicketPane.getCombo2().getValue() == "30 min") {
				costOfBill = costOfBill + 5;
			} else if (buyTicketPane.getCombo2().getValue() == "1 hr") {
				costOfBill = costOfBill + 10;
			} else if (buyTicketPane.getCombo2().getValue() == "12 hr") {
				costOfBill = costOfBill + 40;
			} else if (buyTicketPane.getCombo2().getValue() == "24 hr") {
				costOfBill = costOfBill + 60;
			}
			if (buyTicketPane.getCombo3().getValue() == "VIP Space") {
				costOfBill = costOfBill + vipSpaceCost;
			} else if (buyTicketPane.getCombo3().getValue() == "Handicapped Space") {
				costOfBill = costOfBill + handicappedCost;
			} else if (buyTicketPane.getCombo3().getValue() == "Regular Space") {
				costOfBill = costOfBill + regularSpaceCost;
			}

			if (isFull(handiSpace, regularSpace, vipSpace) == false) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setHeaderText("Congratulations, Your ticket number is: " + counter + " \nYour "
						+ buyTicketPane.getColorField() + " " + buyTicketPane.getCombo1().getValue() + "\n"
						+ "License plate number: " + buyTicketPane.getLicensePlate()
						+ "\nis now stored in our parking system for " + buyTicketPane.getCombo2().getValue());
				alert.setContentText("The cost of your ticket is $" + costOfBill);
				alert.showAndWait();
				createTicket(buyTicketPane, buyTicketPane.getLicenseField().getText(), ticketBag, counter, carCost);
				counter++;
//				ticketBag.printStoredSpaces();
				
			} else {
			}
		}
		return false;
	}

	public void createTicket(BuyTicketPane buyTicketPane, String ticketFieldSelect, TicketBag ticketBag, int counter,
			double cost) {
		ticketFieldSelect = buyTicketPane.getLicenseField().getText();
		Ticket t = new Ticket(ticketFieldSelect, counter, cost);
		ticketBag.addTicket(t);
	}

}

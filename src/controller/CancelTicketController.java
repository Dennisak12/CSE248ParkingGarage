package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.HandicappedSpaces;
import model.RegularSpaces;
import model.Ticket;
import model.TicketBag;
import model.VipSpaces;
import view.CancelTicketPane;
import view.StartPane;

public class CancelTicketController {

	public CancelTicketController(StartPane start, CancelTicketPane cancelTicketPane, HandicappedSpaces handiSpaces,
			RegularSpaces regularSpaces, VipSpaces vipSpaces, TicketBag tickets, Stage mainStage) {
		cancelTicketPane.getOkBtn().setOnAction(e -> {
			vipSpaces.printStoredSpaces();
			handiSpaces.printStoredSpaces();
			cancelTicketPane.getLicenseTextField().getText();
			removeVehicle(cancelTicketPane, handiSpaces, regularSpaces, vipSpaces, tickets);
			
//			tickets.printStoredSpaces();
//			Ticket t = new Ticket(cancelTicketPane.getLicenseTextField().getText(), 0, 0);
//			tickets.isFound(t.getTicketNum());

		});
		cancelTicketPane.getExitBtn().setOnAction(e -> {
			mainStage.setScene(start.getScene());
			mainStage.show();
		});
	}

	public void removeVehicle(CancelTicketPane cancelTicketPane, HandicappedSpaces handiSpace,
			RegularSpaces regularSpace, VipSpaces vipSpace, TicketBag ticketBag) {
		String license = cancelTicketPane.getLicenseTextField().getText();
		Ticket t = new Ticket(license, 0, 0);
		t.getLicensePlate();
		// finds the license plate number if no ticket number was given, and
		// removes it from the given bag
		if (handiSpace.removeVehicle(license) == true) {
			handiSpace.removeVehicle(license);
			alertCar("Vehicle: " + license + " has been removed",
					"Congratulations");
		} else if (regularSpace.removeVehicle(license) == true) {
			regularSpace.removeVehicle(license);
			alertCar("Vehicle: " + license + " has been removed",
					"Congratulations");
		} else if (vipSpace.removeVehicle(license) == true) {
			vipSpace.removeVehicle(license);
			alertCar("Vehicle: " + license + " has been removed",
					"Congratulations");
			
			// finds the ticket, and then the associated parking bag, which
			// removes the ticket from the system AND the parking space.
			
			
			//IMPLEMENTATION MUST BE FIXED
//		} else if (ticketBag.removeTicket(t.getTicketNum()) == true) {
//			ticketBag.removeTicket(t.getTicketNum());
//			if (handiSpace.removeVehicle(license) == true) {
//				handiSpace.removeVehicle(license);
//			} else if (regularSpace.removeVehicle(license) == true) {
//				regularSpace.removeVehicle(license);
//			} else if (vipSpace.removeVehicle(license) == true) {
//				
//				vipSpace.removeVehicle(license);
//				alertCar("Vehicle: " + license + " has been removed", "Congratulations");
//			}
		} else {
			alertCar("This ticket or vehicle is not in our system, sorry!", "Sorry");
		}
	}

	private void alertCar(String message1, String message2) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText(message2);
		alert.setContentText(message1);
		alert.showAndWait();
	}

}

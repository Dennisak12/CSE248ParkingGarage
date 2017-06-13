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
import view.ExtendTimePane;
import view.StartPane;

public class ExtendTimeController {

	private double costOfBill;

	public ExtendTimeController(StartPane start, ExtendTimePane extendTimePane, HandicappedSpaces handiSpaces,
			RegularSpaces regularSpaces, VipSpaces vipSpaces, TicketBag tickets, Stage mainStage) {

		extendTimePane.getExtendTimeButton().setOnAction(e -> {
			handiSpaces.printStoredSpaces();
			vipSpaces.printStoredSpaces();
			extendTimePane.getExtendTimeField().getText();
			extendTime(extendTimePane, handiSpaces, regularSpaces, vipSpaces);

		});

		extendTimePane.getExitBtn().setOnAction(e -> {
			mainStage.setScene(start.getScene());
			mainStage.show();
		});

	}

	public void extendTime(ExtendTimePane extendTimePane, HandicappedSpaces handiSpace, RegularSpaces regularSpace,
			VipSpaces vipSpace) {
		
		String time = extendTimePane.getComboTimeLimit().getValue();
		String license = extendTimePane.getExtendTimeField().getText();
		computeCost(extendTimePane);

		if (handiSpace.isFound(license) == true) {
			alertCar("Vehicle: " + license + " has been given " + time + " added time " + "for $" + costOfBill + " extra" , "Congratulations");
		} else if (regularSpace.isFound(license) == true) {
			alertCar("Vehicle: " + license + " has been given " + time + " added time " + "for $" + costOfBill + " extra" , "Congratulations");
		} else if (vipSpace.isFound(license) == true) {
			alertCar("Vehicle: " + license + " has been given " + time + " added time " + "for $" + costOfBill + " extra" , "Congratulations");
		} else {
			alertCar("This ticket or vehicle is not in our system, sorry!", "Sorry");
		}
	}


	private double computeCost(ExtendTimePane extendTimePane) {
		costOfBill = 0;
		if (extendTimePane.getComboTimeLimit().getValue() == "30 min") {
			costOfBill = costOfBill + 5;
		} else if (extendTimePane.getComboTimeLimit().getValue() == "1 hr") {
			costOfBill = costOfBill + 10;
		} else if (extendTimePane.getComboTimeLimit().getValue() == "12 hr") {
			costOfBill = costOfBill + 40;
		} else if (extendTimePane.getComboTimeLimit().getValue() == "24 hr") {
			costOfBill = costOfBill + 60;
		}
		return costOfBill;
	}

	private void alertCar(String message1, String message2) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText(message2);
		alert.setContentText(message1);
		alert.showAndWait();
	}

}

package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.HandicappedSpaces;
import model.RegularSpaces;
import model.VipSpaces;
import view.CancelTicketPane;
import view.StartPane;

public class CancelTicketController {

	
	public CancelTicketController(StartPane start, CancelTicketPane cancelTicketPane,HandicappedSpaces handiSpaces,RegularSpaces regularSpaces,VipSpaces vipSpaces,Stage mainStage){
		cancelTicketPane.getOkBtn().setOnAction(e -> {
			vipSpaces.printStoredSpaces();
			handiSpaces.printStoredSpaces();
			cancelTicketPane.getLicenseTextField().getText();
			removeVehicle(cancelTicketPane, handiSpaces, regularSpaces, vipSpaces);
			
		});
		
		cancelTicketPane.getExitBtn().setOnAction(e -> {
			mainStage.setScene(start.getScene());
			mainStage.show();
		});
	}
	
	public void removeVehicle(CancelTicketPane cancelTicketPane, HandicappedSpaces handiSpace,RegularSpaces regularSpace,VipSpaces vipSpace){
		String license = cancelTicketPane.getLicenseTextField().getText();
		//false if no match, or car to remove
		if(handiSpace.removeVehicle(license) == true){
			handiSpace.removeVehicle(license);
			alertCar("Vehicle: " + cancelTicketPane.getLicenseTextField().getText() + " has been removed","Congratulations");
		}else if(regularSpace.removeVehicle(license) == true){
			regularSpace.removeVehicle(license);
			alertCar("Vehicle: " + cancelTicketPane.getLicenseTextField().getText() + " has been removed","Congratulations");
		}else if(vipSpace.removeVehicle(license) == true){
			vipSpace.removeVehicle(license);
			alertCar("Vehicle: " + cancelTicketPane.getLicenseTextField().getText() + " has been removed","Congratulations");
		}else{
			alertCar("This vehicle is not in our system, sorry!","Sorry");
		}
		vipSpace.printStoredSpaces();
	}
	
	private void alertCar(String message1,String message2){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText(message2);
		alert.setContentText(message1);
		alert.showAndWait();
	}
	
}

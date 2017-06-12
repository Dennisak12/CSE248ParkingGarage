package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.HandicappedSpaces;
import model.RegularSpaces;
import model.VipSpaces;
import view.ExtendTimePane;
import view.StartPane;

public class ExtendTimeController {

	public ExtendTimeController(StartPane start, ExtendTimePane extendTimePane,HandicappedSpaces handiSpaces, RegularSpaces regularSpaces,VipSpaces vipSpaces, Stage mainStage){
		
		extendTimePane.getExtendTimeButton().setOnAction(e ->{
			
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
	
	public void extendTime(ExtendTimePane extendTimePane, HandicappedSpaces handiSpace,RegularSpaces regularSpace,VipSpaces vipSpace){
		String license = extendTimePane.getExtendTimeField().getText();
		//false if no match, or car to remove
		if(handiSpace.isFound(license) == true){
			handiSpace.isFound(license);
			alertCar("Your Handicapped space has been found");
		}else if(regularSpace.isFound(license) == true){
			regularSpace.isFound(license);
			alertCar("your regular parking space has been found");
		}else if(vipSpace.isFound(license) == true){
			vipSpace.isFound(license);
			alertCar("your vip parking space has been found");
		}else{
			alertCar("This vehicle is not in our system, sorry!");
		}
		vipSpace.printStoredSpaces();
	}
	
	private void alertCar(String message){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
}

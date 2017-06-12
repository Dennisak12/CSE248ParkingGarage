package startApp;

import controller.BuyTicketController;
import controller.CancelTicketController;
import controller.ExtendTimeController;
import controller.StartController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.HandicappedSpaces;
import model.RegularSpaces;
import model.TicketBag;
import model.Vehicle;
import model.VipSpaces;
import view.BuyTicketPane;
import view.CancelTicketPane;
import view.ExtendTimePane;
import view.StartPane;

public class App extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage mainStage) throws Exception {
		
		
		//create the bags to store info
		HandicappedSpaces handiParking = new HandicappedSpaces(0);
		RegularSpaces regularParking = new RegularSpaces(0);
		VipSpaces vipParking = new VipSpaces(0);
		TicketBag ticketBag = new TicketBag(null);
		
		//create the panes
		BuyTicketPane buyTicket = new BuyTicketPane();
		CancelTicketPane cancelTicket = new CancelTicketPane();
		StartPane start = new StartPane();
		ExtendTimePane extendTime = new ExtendTimePane();
		
		//create the controllers
		BuyTicketController buyTicketController = new BuyTicketController(start, buyTicket, handiParking, regularParking, vipParking,ticketBag,mainStage);
		CancelTicketController cancelTicketController = new CancelTicketController(start,cancelTicket, handiParking, regularParking, vipParking,ticketBag,mainStage);
		StartController startController = new StartController(start, extendTime,buyTicket, cancelTicket,ticketBag, mainStage);
		ExtendTimeController extendTimeController = new ExtendTimeController(start, extendTime, handiParking, regularParking, vipParking,ticketBag,mainStage);
		
		//start the program
		Scene scene = start.getScene();
		mainStage.setScene(scene);
		mainStage.show();

	}
}

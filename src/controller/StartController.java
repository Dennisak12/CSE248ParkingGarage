package controller;

import javafx.stage.Stage;
import view.BuyTicketPane;
import view.CancelTicketPane;
import view.ExtendTimePane;
import view.StartPane;

public class StartController {

	public StartController(StartPane startPane,ExtendTimePane extendTimePane, BuyTicketPane buyTicketPane,CancelTicketPane cancelTicketPane,Stage stage) {
		startPane.getBuyTicket().setOnAction(e ->
		{
			stage.setScene(buyTicketPane.getScene());
			stage.show();
		});

		startPane.getCancelTicket().setOnAction(e -> {
			stage.setScene(cancelTicketPane.getScene());
			stage.show();
		});
		
		startPane.getAddTime().setOnAction(e -> {
			stage.setScene(extendTimePane.getScene());
			stage.show();
		});
	}
}

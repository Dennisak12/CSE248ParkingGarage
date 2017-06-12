package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StartPane {

	private Scene scene;
	private HBox pane;
	private Button buyTicket;
	private Button cancelTicket;
	private Button addTime;


	public StartPane() {
		pane = new HBox(10);
		pane.setPadding(new Insets(60, 5, 20, 22));
		

		addTime = new Button("Add time to your ticket");
		buyTicket = new Button("Purchase A Ticket");
		cancelTicket = new Button("Cancel Your Ticket");

		// styling background and button
		addTime.setMinHeight(200);
		addTime.setMinWidth(200);
		addTime.setStyle("-fx-font: 20 arial; -fx-base: #0650c9;");
		buyTicket.setStyle("-fx-font: 20 arial; -fx-base: #0650c9;");
		cancelTicket.setStyle("-fx-font: 20 arial; -fx-base: #0650c9;");
		buyTicket.setMinHeight(200);
		buyTicket.setMinWidth(200);
		cancelTicket.setMinHeight(200);
		cancelTicket.setMinWidth(200);
		pane.setStyle("-fx-background: #4286f4;");
		// end of styling

		pane.getChildren().addAll(buyTicket, cancelTicket, addTime);
		scene = new Scene(pane,700,350);
	}

	public HBox getPane() {
		return pane;
	}

	
	public Scene getScene() {
		return scene;
	}

	public Button getBuyTicket() {
		return buyTicket;
	}

	public Button getCancelTicket() {
		return cancelTicket;
	}

	public Button getAddTime() {
		return addTime;
	}

}

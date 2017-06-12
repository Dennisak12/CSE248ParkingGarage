package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import model.HandicappedSpaces;
import model.RegularSpaces;
import model.VipSpaces;

public class CancelTicketPane {

	private FlowPane pane;
	private Scene scene;

	BuyTicketPane buyTicket = new BuyTicketPane();

	private Label ticketCancel1 = new Label("TICKET CANCELLATION\n_________________________");
	private Label licenseCancelLabel = new Label("Enter your license plate number");
	private TextField licenseTextField = new TextField();
	private Button okBtn = new Button("Confirm");
	private Button exitBtn = new Button("Exit");

	public CancelTicketPane() {
		pane = new FlowPane(10, 10);
		pane.setPadding(new Insets(100, 50, 10, 70));
		scene = new Scene(pane,500,500);
		
		ticketCancel1.setFont(Font.font(30));

		licenseCancelLabel.setFont(Font.font(18));
		licenseTextField.setMaxWidth(100);
		pane.setStyle("-fx-background: #4286f4;");
		pane.getChildren().addAll(ticketCancel1, licenseCancelLabel, licenseTextField, okBtn,exitBtn);

	}

	public FlowPane getPane() {
		return pane;
	}

	public Scene getScene() {
		return scene;
	}

	public BuyTicketPane getBuyTicket() {
		return buyTicket;
	}

	public Label getTicketCancel1() {
		return ticketCancel1;
	}

	public Label getLicenseCancelLabel() {
		return licenseCancelLabel;
	}

	public TextField getLicenseTextField() {
		return licenseTextField;
	}

	public Button getOkBtn() {
		return okBtn;
	}
	
	public Button getExitBtn() {
		return exitBtn;
	}
	
}

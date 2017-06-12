package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Car;
import model.HandicappedSpaces;
import model.RegularSpaces;
import model.Suv;
import model.Truck;
import model.VipSpaces;

public class BuyTicketPane {

	private VBox pane;
	private Scene scene;
	 
	// creating the space lists
	public HandicappedSpaces handiSpace = new HandicappedSpaces(0);
	public RegularSpaces regularSpace = new RegularSpaces(0);
	public VipSpaces vipSpace = new VipSpaces(0);

	// initializing nodes
	private Button exitButton;
	private Button orderTicket;
	private TextField licenseField;
	private Label licenseLabel;

	private TextField colorField;
	private Label colorLabel;

	private Label selectCarLabel;
	private Label selectTimeLabel;
	private Label selectSpaceLabel;

	ObservableList<String> vehicleOptions = FXCollections.observableArrayList("SUV", "TRUCK", "CAR");
	private ComboBox<String> combo1 = new ComboBox<String>(vehicleOptions);
	ObservableList<String> timeLimitOption = FXCollections.observableArrayList("30 min", "1 hr", "12 hr", "24 hr");
	private ComboBox<String> combo2 = new ComboBox<String>(timeLimitOption);
	ObservableList<String> requiredSpace = FXCollections.observableArrayList("VIP Space", "Handicapped Space",
			"Regular Space");
	private ComboBox<String> combo3 = new ComboBox<String>(requiredSpace);

	public BuyTicketPane() {
		
		pane = new VBox(10);
		pane.setPadding(new Insets(5, 5, 5, 70));
		scene = new Scene(pane,590,400);
		
		
		exitButton = new Button("Exit");
		licenseLabel = new Label("Please enter your license Plate Number");
		colorLabel = new Label("Please enter the color of your vehicle");
		selectCarLabel = new Label("Please select your type of vehicle");
		selectTimeLabel = new Label("Please select your desired time");
		selectSpaceLabel = new Label("Please select your desired parking space");
		orderTicket = new Button("Confirm Purchase");
		licenseField = new TextField();
		colorField = new TextField();

		colorField.setMaxWidth(100);
		licenseField.setMaxWidth(100);
		pane.setStyle("-fx-background: #4286f4;");

		pane.getChildren().addAll(licenseLabel, licenseField, colorLabel, colorField, selectCarLabel, combo1,
				selectTimeLabel, combo2, selectSpaceLabel, combo3, orderTicket, exitButton);

	}

	public VBox getPane() {
		return pane;
	}

	public void setLicensePlate(String licensePlate) {
		licenseField.setText(licensePlate);
	}

	public String getLicensePlate() {
		return licenseField.getText();
	}

	public void setColorField(String color) {
		licenseField.setText(color);
	}

	public String getColorField() {
		return colorField.getText();
	}

	public Scene getScene() {
		return scene;
	}

	public HandicappedSpaces getHandiSpace() {
		return handiSpace;
	}

	public RegularSpaces getRegularSpace() {
		return regularSpace;
	}

	public VipSpaces getVipSpace() {
		return vipSpace;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public Button getOrderTicket() {
		return orderTicket;
	}

	public TextField getLicenseField() {
		return licenseField;
	}

	public Label getLicenseLabel() {
		return licenseLabel;
	}

	public Label getColorLabel() {
		return colorLabel;
	}

	public Label getSelectCarLabel() {
		return selectCarLabel;
	}

	public Label getSelectTimeLabel() {
		return selectTimeLabel;
	}

	public Label getSelectSpaceLabel() {
		return selectSpaceLabel;
	}

	public ObservableList<String> getVehicleOptions() {
		return vehicleOptions;
	}

	public ComboBox<String> getCombo1() {
		return combo1;
	}

	public ObservableList<String> getTimeLimitOption() {
		return timeLimitOption;
	}

	public ComboBox<String> getCombo2() {
		return combo2;
	}

	public ObservableList<String> getRequiredSpace() {
		return requiredSpace;
	}

	public ComboBox<String> getCombo3() {
		return combo3;
	}
	
	

}
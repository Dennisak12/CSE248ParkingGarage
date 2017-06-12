package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ExtendTimePane {

	private VBox pane;
	private Scene scene;

	private Button extendTimeButton = new Button("Confirm");
	private Button exitBtn = new Button("Exit");
	private TextField extendTimeField = new TextField();
	private Label extendTimeLabel = new Label("Enter the license plate number");
	private Label extendTimeLabel2 = new Label("Select The amount of added time");
	ObservableList<String> timeLimitOption = FXCollections.observableArrayList("30 min", "1 hr", "12 hr", "24 hr");
	private ComboBox<String> comboTimeLimit = new ComboBox<String>(timeLimitOption);
	

	public ExtendTimePane() {
		pane = new VBox(10);
		pane.setPadding(new Insets(5, 5, 5, 70));
		pane.setStyle("-fx-background: #4286f4;");
		scene = new Scene(pane,500,500);
		
		extendTimeField.setMaxWidth(100);
		extendTimeLabel.setFont(Font.font(20));
		extendTimeLabel2.setFont(Font.font(20));
		
		pane.getChildren().addAll(extendTimeLabel, extendTimeField,extendTimeLabel2,comboTimeLimit, extendTimeButton,exitBtn);
	}

	public Scene getScene() {
		return scene;
	}

	public Button getExtendTimeButton() {
		return extendTimeButton;
	}

	public TextField getExtendTimeField() {
		return extendTimeField;
	}

	public Label getExtendTimeLabel() {
		return extendTimeLabel;
	}

	public VBox getPane() {
		return pane;
	}
	
	public Button getExitBtn() {
		return exitBtn;
	}
}

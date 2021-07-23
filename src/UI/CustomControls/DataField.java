package UI.CustomControls;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DataField extends Region {

    private TextField textField;
    private Label label;
    private VBox container;

    public DataField(TextField textField, String labelName) {
        this.textField = textField;
        this.textField.setMinSize(300, 35);
        this.textField.setMaxSize(300, 35);
        this.textField.getStylesheets().add("UI/Style/TextField.css");
        this.label = new Label(labelName);
        this.container = new VBox(5);
        this.container.getChildren().addAll(this.label, this.textField);
        super.getChildren().add(this.container);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 55;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 300;
    }

    public TextField getTextField() {
        return this.textField;
    }

    public void displayErrorMessage(String msg) {
        this.label.setTextFill(Color.RED);
        this.label.setText(this.label.getText() + " " + msg);
    }
}

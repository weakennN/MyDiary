package MyDiary.UI.CustomControls;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class DataField extends Region {

    private String labelName;
    private TextField textField;
    private Label label;
    private VBox container;
    private boolean displayed;

    public DataField(TextField textField, String labelName) {
        this.labelName = labelName;
        this.displayed = false;
        this.textField = textField;
        this.textField.setMinSize(300, 35);
        this.textField.setMaxSize(300, 35);
        this.textField.setFont(Font.font("Arial", FontPosture.REGULAR, 15));
        this.textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
        this.textField.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), null)));
        this.label = new Label(labelName);
        this.label.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.REGULAR, 15));
        this.container = new VBox(5);
        this.container.getChildren().addAll(this.label, this.textField);
        super.getChildren().add(this.container);
    }

    public void displayErrorMessage(String msg) {
        this.label.setTextFill(Color.RED);
        this.label.setText(this.label.getText() + " " + msg);
        this.displayed = true;
    }

    public void removeErrorMessage() {
        if (this.displayed) {
            this.label.setTextFill(Color.BLACK);
            this.label.setText(this.labelName);
            this.displayed = false;
        }
    }

    public Label getLabel() {
        return this.label;
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
}

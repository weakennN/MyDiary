package UI.CustomControls.NoteMenuControls;

import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

public class TTextField extends Region {

    private TextField textField;

    public TTextField() {
        this.init();
    }

    private void init() {
        this.textField = new TextField();
        this.textField.getStylesheets().add("UI/Style/TextField.css");
        this.textField.setMinSize(500, 30);
        this.textField.setFont(Font.font("Arial", 16));
        super.getChildren().add(this.textField);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 30;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 500;
    }

    public TextField getTextField() {
        return this.textField;
    }
}

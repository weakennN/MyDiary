package UI.CustomControls.NoteMenuControls;

import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.util.Locale;

public class CTextField extends Region {

    private DatePicker datePicker;

    public CTextField() {
        this.initStyle();
    }

    private void initStyle() {
        this.datePicker = new DatePicker(LocalDate.now());
        this.datePicker.setMinSize(500, 35);
        // this.datePicker.getEditor().getStylesheets().add("UI/Style/CTextField.css");
        this.datePicker.getEditor().setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), null)));
        this.datePicker.getEditor().setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT, null)));
        this.datePicker.getStylesheets().add("UI/Style/CTextField.css");
        this.datePicker.getEditor().setFont(Font.font("Arial", 16));
        this.datePicker.getEditor().alignmentProperty().set(Pos.CENTER);
        this.datePicker.getEditor().setOnMouseClicked(e -> {
            this.datePicker.show();
        });

        this.setDate(LocalDate.now());

        this.datePicker.setOnAction(e -> {
            this.setDate(this.datePicker.getValue());
        });

        this.datePicker.setEditable(false);

        super.getChildren().add(this.datePicker);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 30;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 500;
    }

    private void setDate(LocalDate localDate) {
        String dayOfWeek = localDate.getDayOfWeek().toString().charAt(0) + this.datePicker.getValue().getDayOfWeek().toString().substring(1).toLowerCase(Locale.ROOT);
        int dayOfMonth = localDate.getDayOfMonth();
        String month = localDate.getMonth().toString().charAt(0) + this.datePicker.getValue().getMonth().toString().substring(1).toLowerCase(Locale.ROOT);
        int year = localDate.getYear();
        this.datePicker.getEditor().setText(dayOfWeek + ", " + dayOfMonth + " " + month + " " + year);
    }

    public DatePicker getDatePicker() {
        return this.datePicker;
    }

    public void resetDate() {
        this.setDate(LocalDate.now());
    }
}

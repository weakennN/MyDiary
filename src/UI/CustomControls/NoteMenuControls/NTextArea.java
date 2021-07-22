package UI.CustomControls.NoteMenuControls;

import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class NTextArea extends Region {

    private TextArea textArea;

    public NTextArea() {
        this.textArea = new TextArea();
        this.textArea.setWrapText(true);
        this.textArea.getStylesheets().add("UI/Style/TextArea.css");
        this.textArea.setFont(Font.font("Arial", 16));
        this.textArea.setMinSize(500, 400);
        this.textArea.setMaxSize(500, 400);
        this.textArea.setPrefSize(500, 400);
        super.getChildren().add(this.textArea);
    }

    public TextArea getTextArea() {
        return this.textArea;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 400;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 500;
    }
}

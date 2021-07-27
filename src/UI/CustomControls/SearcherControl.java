package UI.CustomControls;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;

public class SearcherControl extends Region {

    private TextField textField;
    private Button button;

    public SearcherControl() {
        this.initStyle();
    }

    private void initStyle() {
        this.button = new Button();
        this.button.setMinSize(75, 50);
        this.button.setMaxSize(75, 50);
        this.button.setText("Search");
        this.button.setViewOrder(1);
        this.button.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), null)));
        this.button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT, null)));
        this.button.setLayoutX(815);
        this.button.setTextAlignment(TextAlignment.CENTER);
        this.button.setFont(Font.font("Arial", FontPosture.REGULAR, 15));

        this.textField = new TextField();
        this.textField.setMinSize(880, 50);
        this.textField.setLayoutX(10);
        this.textField.setViewOrder(2);
        this.textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT, null)));
        this.textField.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), null)));
        this.textField.setFont(Font.font("Arial", FontPosture.REGULAR, 17.5));
        super.getChildren().addAll(this.textField, this.button);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 50;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 900;
    }

    public TextField getTextField() {
        return this.textField;
    }

    public Button getButton() {
        return this.button;
    }
}

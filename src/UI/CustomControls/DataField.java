package UI.CustomControls;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DataField extends Region {

    private TextField textField;
    private Label errorMessage;
    private Rectangle rec;

    public DataField(String errorMessage) {
        this.init(errorMessage);
    }

    private void init(String errorMessage) {
        this.textField = new TextField();
        this.textField.setMinSize(100, 40);
        this.textField.setFont(Font.font("Arial",14));
        this.errorMessage = new Label(errorMessage);
        double width = 0;
        for (int i = 0; i < this.errorMessage.getText().length(); i++) {

            Text text = new Text(this.errorMessage.getText().charAt(i) + "");
            text.setFont(this.errorMessage.getFont());
            width += text.getBoundsInLocal().getWidth();
        }
        this.errorMessage.setViewOrder(50);
        this.errorMessage.setMinSize(width, 50);
        this.rec = new Rectangle();
        this.rec.setViewOrder(51);
        this.rec.setWidth(width + 20);
        this.rec.setHeight(45);
        this.rec.setFill(Color.RED);
        super.getChildren().add(this.textField);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 50;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 100;
    }

    public void showErrorMessage() {
      /*  this.rec.setLayoutX(super.getLayoutX() + this.textField.getMinWidth() + 20);
        this.rec.setLayoutY(super.getLayoutY() + this.textField.getMinHeight() / 2);
        this.errorMessage.setTextFill(Color.WHITE);
        this.errorMessage.setLayoutX(this.rec.getLayoutX() + 10);
        this.errorMessage.setLayoutY(this.rec.getLayoutY() + this.errorMessage.getMinHeight() / 2);
        super.getChildren().add(this.rec);
        super.getChildren().add(this.errorMessage);

       */
    }

    public TextField getTextField() {
        return this.textField;
    }
}

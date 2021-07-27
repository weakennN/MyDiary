package UI.CustomControls;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class EButton extends Button {

    public EButton(String title) {
        super();
        super.setText(title);
        this.init();
    }

    public EButton() {
        this("");
    }

    private void init() {
        super.setTextAlignment(TextAlignment.CENTER);
        super.setMinSize(300, 45);
        super.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), null)));
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT, null)));
        super.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 16));

        super.setOnMouseEntered(e -> {
            super.setBackground(new Background(new BackgroundFill(Color.valueOf("fafafa"), new CornerRadii(5), null)));
        });

        super.setOnMouseExited(e -> {
            super.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), null)));
        });
    }
}

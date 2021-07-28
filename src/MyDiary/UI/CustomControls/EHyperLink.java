package MyDiary.UI.CustomControls;

import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class EHyperLink extends Hyperlink {

    public EHyperLink(String text) {
        super();
        super.setText(text);
        this.init();
    }

    private void init() {
        super.setMinSize(300, 30);
        super.alignmentProperty().set(Pos.CENTER);
        super.setTextFill(Color.BLUE);
        super.setFont(Font.font("Arial", FontPosture.REGULAR,14.5));
        super.setUnderline(false);
        super.setBorder(null);

        super.setOnMouseEntered(e -> {
            super.setUnderline(true);
        });

        super.setOnMouseExited(e -> {
            super.setUnderline(false);
        });
    }
}

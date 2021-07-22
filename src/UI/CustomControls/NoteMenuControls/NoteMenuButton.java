package UI.CustomControls.NoteMenuControls;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class NoteMenuButton extends Button {

    public NoteMenuButton() {
        super.setMinSize(65, 35);
        super.setBackground(new Background(new BackgroundFill(Color.valueOf("268bff"), new CornerRadii(5), null)));
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT, null)));
    }
}

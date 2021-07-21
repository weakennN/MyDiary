package UI.CustomControls.NoteControl;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.List;

public class NoteControl extends Region {

    private Label monthLabel;
    private Label dayLabel;
    private Label titleLabel;
    private Label textLabel;
    private Label yearLabel;
    private VBox dateVbox;
    private VBox textVbox;
    private Rectangle rectangle;

    public NoteControl(int day, int year, Month month, String title, String text) {
        this.init(day, year, month, title, text);
    }

    // TODO: finish the style
    private void init(int day, int year, Month month, String title, String text) {
        this.monthLabel = new Label(month.getMonth());
        this.dayLabel = new Label(day + "");
        this.yearLabel = new Label(month.getMonth() + "/" + year);
        this.titleLabel = new Label(title);
        this.textLabel = new Label(text);
        this.rectangle = new Rectangle(0, 0, 5, 75);
        this.rectangle.setFill(Color.valueOf(month.getColor()));

        this.dateVbox = new VBox();
        this.dateVbox.setMinSize(68, 50);
        this.dateVbox.setMaxSize(68, 50);

        List<Label> labels = List.of(this.monthLabel, this.dayLabel, this.yearLabel);

        for (Label label : labels) {
            label.setMinWidth(this.dateVbox.getMinWidth());
            label.setMaxWidth(this.dateVbox.getMinWidth());
            label.setFont(Font.font("Helvetica", FontPosture.REGULAR, 13.5));
        }
        this.dayLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 16.5));
        this.monthLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 13.5));
        this.monthLabel.setTextFill(Color.valueOf("e4ecf0"));

        this.monthLabel.setBackground(new Background(new BackgroundFill(Color.valueOf(month.getColor()), null, null)));
        this.dayLabel.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.yearLabel.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.dateVbox.getChildren().addAll(this.monthLabel, this.dayLabel, this.yearLabel);
        this.dateVbox.setPadding(new Insets(5, 0, 0, 10));

        this.textVbox = new VBox(5);
        this.textVbox.setMaxWidth(805);
        this.textVbox.setPadding(new Insets(10,0,0,0));

        labels = List.of(this.titleLabel, this.textLabel);

        for (Label label : labels) {
            label.setMaxWidth(805);
            this.textVbox.getChildren().add(label);
        }

        this.textVbox.setLayoutX(95);

        this.titleLabel.setFont(Font.font("Trebuchet MS", FontWeight.SEMI_BOLD, 20));

        this.textLabel.setFont(Font.font("Trebuchet MS", 17));

        super.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        super.getChildren().addAll(this.dateVbox, this.textVbox, this.rectangle);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 75;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 900;
    }

   /* public void test() {
        super.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 0, 0, 0))));
    }
    */
}

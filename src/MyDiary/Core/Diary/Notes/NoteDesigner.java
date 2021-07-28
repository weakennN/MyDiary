package MyDiary.Core.Diary.Notes;

import MyDiary.UI.CustomControls.NoteControl.Month;
import MyDiary.UI.CustomControls.NoteControl.NoteControl;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public abstract class NoteDesigner extends Region {

    private NoteControl noteControl;

    public NoteDesigner(int day, String weekDay, int year, Month month, String title, String text) {
        this.noteControl = new NoteControl(day, weekDay, year, month, title, text);
        super.getChildren().add(this.noteControl);
        super.setOnMouseEntered(e -> {
            this.noteControl.setBackground(new Background(new BackgroundFill(Color.valueOf("dbdbd9"), null, null)));
        });
        super.setOnMouseExited(e -> {
            this.noteControl.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        });
    }

    public NoteControl getNoteControl() {
        return this.noteControl;
    }

    public void setTitle(String title) {
        this.noteControl.getTitleLabel().setText(title);
    }

    public void setText(String text) {
        this.noteControl.getTextLabel().setText(text);
    }

    public void setWeekDay(String weekDay) {
        this.noteControl.getWeekDayLabel().setText(weekDay);
    }

    public void setMonthDay(int monthDay) {
        this.noteControl.getMonthDayLabel().setText(monthDay + "");
    }

    public void setMonth(Month month, int year) {
        this.noteControl.getRectangle().setFill(Color.valueOf(month.getColor()));
        this.noteControl.getYearLabel().setText(month.getMonth() + "/" + year);
        this.noteControl.setBackground(this.noteControl.getWeekDayLabel(), Color.valueOf(month.getColor()));
    }
}

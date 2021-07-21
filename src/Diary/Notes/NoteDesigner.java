package Diary.Notes;

import UI.CustomControls.NoteControl.Month;
import UI.CustomControls.NoteControl.NoteControl;
import javafx.scene.layout.Region;

public abstract class NoteDesigner extends Region {

    private NoteControl noteControl;

    public NoteDesigner(int day, int year, Month month, String title, String text) {
        this.noteControl = new NoteControl(day, year, month, title, text);
        super.getChildren().add(this.noteControl);
    }

    public NoteControl getNoteControl() {
        return this.noteControl;
    }
}

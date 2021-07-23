package Diary.Notes.NoteCreator;

import Common.NoteClicked;
import Common.SceneContentChanger;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import UI.CustomControls.NoteControl.Month;
import javafx.scene.input.MouseButton;

import java.util.Locale;

public class NoteCreator extends NoteCreatorDesigner {

    private Diary diary;

    public NoteCreator(Diary diary) {
        super();
        this.diary = diary;
        this.initActions();
    }

    private void initActions() {
        this.setCreateAction();

        super.getGoBackButton().setOnAction(e -> {
            super.clearFields();
            SceneContentChanger.changeContent("mainContent");
        });
    }

    private void saveNote() {
        int day = super.getCTextField().getDatePicker().getValue().getDayOfMonth();
        String weekDay = super.getCTextField().getDatePicker().getValue().getDayOfWeek().toString().charAt(0)
                + super.getCTextField().getDatePicker().getValue().getDayOfWeek().toString().substring(1).toLowerCase(Locale.ROOT);
        int year = super.getCTextField().getDatePicker().getValue().getYear();
        Month month = Month.findByName(super.getCTextField().getDatePicker().getValue().getMonth().toString());
        String title = super.getTTextField().getTextField().getText();
        String text = super.getNTextArea().getTextArea().getText();
        Note note = new Note(day, weekDay, year, month, title, text);
        note.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                super.setFields(note);
                SceneContentChanger.changeContent("noteMenu");
                this.setEditAction();
            }
            NoteClicked.note = note;
        });
        this.diary.addNote(note);
    }

    public void setCreateAction() {
        super.getSaveButton().setOnAction(e -> {
            this.saveNote();
            SceneContentChanger.changeContent("mainContent");
        });
    }

    public void setEditAction() {
        super.getSaveButton().setOnAction(e -> {
            Note note = NoteClicked.note;
            int day = super.getCTextField().getDatePicker().getValue().getDayOfMonth();
            String weekDay = super.getCTextField().getDatePicker().getValue().getDayOfWeek().toString().charAt(0)
                    + super.getCTextField().getDatePicker().getValue().getDayOfWeek().toString().substring(1).toLowerCase(Locale.ROOT);
            int year = super.getCTextField().getDatePicker().getValue().getYear();
            Month month = Month.findByName(super.getCTextField().getDatePicker().getValue().getMonth().toString());
            String title = super.getTTextField().getTextField().getText();
            String text = super.getNTextArea().getTextArea().getText();
            note.setMonthDay(day);
            note.setWeekDay(weekDay);
            note.setMonth(month, year);
            note.setTitle(title);
            note.setText(text);
            SceneContentChanger.changeContent("mainContent");
        });
    }

    public Diary getDiary() {
        return this.diary;
    }
}

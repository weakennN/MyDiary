package Diary.Notes.NoteCreator;

import Common.NoteClicked;
import Common.SceneContentChanger;
import Database.Database;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import UI.CustomControls.NoteControl.Month;
import UI.Designer;
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
        Database.registerNote(note.getUniqueId(), this.diary.getUniqueId(), title, text, weekDay, day, month.toString(), year);
        this.initNoteDefaultActions(note);
        this.diary.addNote(note);
    }

    public void setCreateAction() {
        super.getSaveButton().setOnAction(e -> {
            this.saveNote();
            SceneContentChanger.changeContent("mainContent");
            super.clearFields();
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
            Database.editNote(note.getUniqueId(), title, text, weekDay, day, month.toString(), year);
            SceneContentChanger.changeContent("mainContent");
        });
    }

    public Diary getDiary() {
        return this.diary;
    }

    private void initNoteDefaultActions(Note note) {
        note.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                super.setFields(note);
                SceneContentChanger.changeContent("noteMenu");
                this.setEditAction();
            } else if (e.getButton().equals(MouseButton.SECONDARY)) {
                this.diary.getMenu("NoteContextMenu").show(Designer.stage, e.getScreenX(), e.getScreenY());
            }
            NoteClicked.note = note;
        });
    }
}

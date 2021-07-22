package Diary.Notes.NoteCreator;

import Action.CreateNoteAction;
import Action.EditNoteAction;
import Action.NoteCreatorAction;
import Common.SceneContentChanger;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import UI.CustomControls.NoteControl.Month;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NoteCreator extends NoteCreatorDesigner {

    private Diary diary;
    private Map<String, NoteCreatorAction> actions;

    public NoteCreator(Diary diary) {
        super();
        this.diary = diary;
        this.actions = new HashMap<>();
        this.actions.put("save", new CreateNoteAction(super.getSaveButton(), this));
        this.actions.put("edit", new EditNoteAction(super.getSaveButton(), this));
        this.initActions();
    }

    private void initActions() {

        this.actions.get("save").initAction();

        super.getGoBackButton().setOnAction(e -> {
            super.clearFields();
            SceneContentChanger.changeContent("mainContent");
        });
    }

    private void saveNote() {
     /*   int day = super.getCTextField().getDatePicker().getValue().getDayOfMonth();
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
            }
            NoteClicked.note = note;
        });
        this.diary.addNote(note);

      */
    }

    public Note createNote() {
        int day = super.getCTextField().getDatePicker().getValue().getDayOfMonth();
        String weekDay = super.getCTextField().getDatePicker().getValue().getDayOfWeek().toString().charAt(0)
                + super.getCTextField().getDatePicker().getValue().getDayOfWeek().toString().substring(1).toLowerCase(Locale.ROOT);
        int year = super.getCTextField().getDatePicker().getValue().getYear();
        Month month = Month.findByName(super.getCTextField().getDatePicker().getValue().getMonth().toString());
        String title = super.getTTextField().getTextField().getText();
        String text = super.getNTextArea().getTextArea().getText();
        return new Note(day, weekDay, year, month, title, text);
    }

    public Diary getDiary() {
        return this.diary;
    }

    public NoteCreatorAction getAction(String key) {
        return this.actions.get(key);
    }
}

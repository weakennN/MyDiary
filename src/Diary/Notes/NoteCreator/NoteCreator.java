package Diary.Notes.NoteCreator;

import Common.ActionInitializer;
import Common.NoteClicked;
import Common.SceneContentChanger;
import Database.*;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import UI.CustomControls.NoteControl.Month;

import java.util.Map;

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
        Map<String, String> noteValues = super.getNoteValues();

        int day = Integer.parseInt(noteValues.get("day"));
        String weekDay = noteValues.get("weekDay");
        int year = Integer.parseInt(noteValues.get("year"));
        Month month = Month.findByName(noteValues.get("month"));
        String title = noteValues.get("title");
        String text = noteValues.get("text");

        Note note = new Note(day, weekDay, year, month, title, text);
        DiaryManagement.registerNote(this.diary.getUniqueId(), title, text, weekDay, day, month.toString(), year);
        note.setId(DiaryManagement.getNoteId(this.diary.getUniqueId(), title, text, weekDay, day, month.toString(), year));
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
            Map<String, String> noteValues = super.getNoteValues();
            int day = Integer.parseInt(noteValues.get("day"));
            String weekDay = noteValues.get("weekDay");
            int year = Integer.parseInt(noteValues.get("year"));
            Month month = Month.findByName(noteValues.get("month"));
            String title = noteValues.get("title");
            String text = noteValues.get("text");
            note.setMonthDay(day);
            note.setWeekDay(weekDay);
            note.setMonth(month, year);
            note.setTitle(title);
            note.setText(text);
            DiaryManagement.editNote(note.getUniqueId(), title, text, weekDay, day, month.toString(), year);
            SceneContentChanger.changeContent("mainContent");
        });
    }

    public Diary getDiary() {
        return this.diary;
    }

    private void initNoteDefaultActions(Note note) {
        ActionInitializer.initNoteDefaultActions(note, diary);
    }
}

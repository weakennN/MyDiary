package Diary.Diary;

import Diary.Notes.Note;

import java.util.ArrayList;
import java.util.List;

public class Diary extends DiaryDesigner {

    private int id;
    private List<Note> notes;

    public Diary(int id) {
        this.id = id;
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        this.notes.add(note);
        super.addToContainer(note);
    }

    public void removeNode(Note note) {
        this.notes.remove(note);
        super.removeFromContainer(note);
    }

    public List<Note> getNotes() {
        return this.notes;
    }

    public void changeNode(Note oldNote, Note newNote) {
        oldNote.setTitle(newNote.getTitle());
    }
}

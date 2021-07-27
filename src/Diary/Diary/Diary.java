package Diary.Diary;

import Diary.Notes.Note;
import RightClickMenu.Menu.DiaryMenu;

import java.util.*;

public class Diary extends DiaryDesigner {

    private int id;
    private Map<Integer, Note> notes;
    private Map<String, DiaryMenu> menus;

    public Diary(int id) {
        this.id = id;
        this.notes = new LinkedHashMap<>();
        this.menus = new HashMap<>();
        this.menus.put("NoteContextMenu", new DiaryMenu(this));
    }

    public void addNote(Note note) {
        this.notes.put(note.getUniqueId(), note);
        super.addToContainer(note);
    }

    public void removeNote(Note note) {
        this.notes.remove(note.getUniqueId());
        super.removeFromContainer(note);
    }

    public Map<Integer, Note> getNotes() {
        return this.notes;
    }

    public void resetNotes() {
        super.getNotesContainer().getChildren().clear();
        List<Note> test = new ArrayList<>(this.notes.values());
        super.getNotesContainer().getChildren().addAll(test);
    }

    public Note getNote(int id) {
        return this.notes.get(id);
    }

    public void setNotes(List<Note> notes) {
        super.getNotesContainer().getChildren().clear();
        super.getNotesContainer().getChildren().addAll(notes);
    }

    public DiaryMenu getMenu(String key) {
        return this.menus.get(key);
    }

    public int getUniqueId() {
        return this.id;
    }
}

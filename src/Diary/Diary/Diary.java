package Diary.Diary;

import Diary.Notes.Note;
import RightClickMenu.Menu.DiaryMenu;

import java.util.*;

public class Diary extends DiaryDesigner {

    private String id;
    private Map<String, Note> notes;
    private Map<String, DiaryMenu> menus;

    public Diary(String id) {
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

    public Map<String, Note> getNotes() {
        return this.notes;
    }

    public void test() {
        super.getNotesContainer().getChildren().clear();
        List<Note> test = new ArrayList<>(this.notes.values());
        super.getNotesContainer().getChildren().addAll(test);
    }

    public Note getNote(String id) {
        return this.notes.get(id);
    }

    public void setNotes(List<Note> notes) {
        super.getNotesContainer().getChildren().clear();
        super.getNotesContainer().getChildren().addAll(notes);
    }

    public DiaryMenu getMenu(String key) {
        return this.menus.get(key);
    }

    public String getUniqueId() {
        return this.id;
    }
}

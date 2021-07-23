package Diary.Diary;

import Diary.Notes.Note;
import RightClickMenu.Menu.DiaryMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Diary extends DiaryDesigner {

    private int id;
    private List<Note> notes;
    private Map<String, DiaryMenu> menus;

    public Diary(int id) {
        this.id = id;
        this.notes = new ArrayList<>();
        this.menus = new HashMap<>();
        this.menus.put("NoteContextMenu", new DiaryMenu(this));
    }

    public void addNote(Note note) {
        this.notes.add(note);
        super.addToContainer(note);
    }

    public void removeNote(Note note) {
        this.notes.remove(note);
        super.removeFromContainer(note);
    }

    public List<Note> getNotes() {
        return this.notes;
    }

    public DiaryMenu getMenu(String key) {
        return this.menus.get(key);
    }

    public int getUniqueId() {
        return this.id;
    }
}

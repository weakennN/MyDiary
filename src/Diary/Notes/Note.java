package Diary.Notes;

import UI.CustomControls.NoteControl.Month;

public class Note extends NoteDesigner {

    private int day;
    private int year;
    private Month month;
    private String title;
    private String text;

    public Note(int day, int year, Month month, String title, String text) {
        super(day, year, month, title, text);
        this.day = day;
        this.year = year;
        this.month = month;
        this.title = title;
        this.text = text;
    }
}

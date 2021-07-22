package Diary.Notes;

import UI.CustomControls.NoteControl.Month;

public class Note extends NoteDesigner {

    private int monthDay;
    private String weekDay;
    private int year;
    private Month month;
    private String title;
    private String text;

    public Note(int monthDay, String weekDay, int year, Month month, String title, String text) {
        super(monthDay, weekDay, year, month, title, text);
        this.monthDay = monthDay;
        this.year = year;
        this.month = month;
        this.title = title;
        this.text = text;
        this.weekDay = weekDay;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public int getMonthDay() {
        return this.monthDay;
    }

    public int getYear() {
        return this.year;
    }

    public Month getMonth() {
        return this.month;
    }
}

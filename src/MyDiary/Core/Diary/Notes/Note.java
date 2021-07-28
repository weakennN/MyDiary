package MyDiary.Core.Diary.Notes;

import MyDiary.UI.CustomControls.NoteControl.Month;

public class Note extends NoteDesigner {

    private int id;
    private int monthDay;
    private String weekDay;
    private int year;
    private Month month;
    private String title;
    private String text;

    public Note(int monthDay, String weekDay, int year, Month month, String title, String text) {
        super(monthDay, weekDay, year, month, title, text);
        this.monthDay = monthDay;
        this.weekDay = weekDay;
        this.year = year;
        this.month = month;
        this.title = title;
        this.text = text;
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

    public void setTitle(String title) {
        this.title = title;
        super.setTitle(title);
    }

    public void setText(String text) {
        this.text = text;
        super.setText(text);
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
        super.setWeekDay(weekDay);
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
        super.setMonthDay(monthDay);
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setMonth(Month month, int year) {
        this.year = year;
        this.month = month;
        super.setMonth(month, year);
    }

    public int getUniqueId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

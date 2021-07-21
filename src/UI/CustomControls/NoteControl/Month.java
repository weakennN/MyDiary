package UI.CustomControls.NoteControl;

import java.util.Locale;

public enum Month {

    JULY("JUL", "0356fc");

    private String month;
    private String color;

    Month(String month, String color) {
        this.month = month;
        this.color = color;
    }

    public static Month findByName(String name) {
        Month[] months = values();

        for (Month month : months) {
            if (month.toString().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))) {
                return month;
            }
        }

        return null;
    }

    public String getMonth() {
        return this.month;
    }

    public String getColor() {
        return this.color;
    }
}

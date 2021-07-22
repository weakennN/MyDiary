package UI.CustomControls.NoteControl;

import java.util.Locale;

public enum Month {

    JANUARY("JAN", "5698f5"),
    FEBRUARY("FEB", "4307f7"),
    MARCH("MAR", "ff03cd"),
    APRIL("APR", "ff0370"),
    MAY("MAY", "0ff290"),
    JULY("JUL", "0356fc"),
    JUNE("JUN", "eb1313"),
    AUGUST("AUG", "d1fa07"),
    SEPTEMBER("SEP", "fc4103"),
    OCTOBER("OCT", "f55ff0"),
    NOVEMBER("NOV", "5de892"),
    DECEMBER("DEC", "c5e058");

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

package RightClickMenu.MenuItem;

import Diary.Diary.Diary;

public abstract class DiaryMenuItem extends BaseMenuItem {

    private Diary diary;

    public DiaryMenuItem(Diary diary) {
        super();
        this.diary = diary;
    }

    protected Diary getDiary() {
        return this.diary;
    }
}

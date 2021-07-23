package RightClickMenu.Menu;

import Diary.Diary.Diary;
import RightClickMenu.MenuItem.RemoveNote;

public class DiaryMenu extends BaseMenu {

    private Diary diary;

    public DiaryMenu(Diary diary) {
        this.diary = diary;
        this.initMenu();
    }

    @Override
    public void initMenu() {
        super.getItems().add(new RemoveNote(this.diary));
    }
}

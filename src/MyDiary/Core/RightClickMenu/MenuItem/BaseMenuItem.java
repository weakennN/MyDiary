package MyDiary.Core.RightClickMenu.MenuItem;

import javafx.scene.control.MenuItem;

public abstract class BaseMenuItem extends MenuItem {

    public BaseMenuItem() {
        this.doAction();
    }

    public abstract void doAction();
}

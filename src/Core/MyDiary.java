package Core;

import Common.SceneContentChanger;
import Content.MainContent;
import Database.Database;
import Diary.Diary.Diary;
import LoginSystem.LoginSystem;

public class MyDiary {

    private LoginSystem loginSystem;
    private Diary diary;

    public MyDiary() {
    }

    public void start() {
        Database.makeConnection();
        this.loginSystem = new LoginSystem(this);
    }

    public void stop() {
        Database.closeConnection();
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
        SceneContentChanger.addContent("mainContent", new MainContent(this.diary));
        SceneContentChanger.changeContent("mainContent");
    }
}

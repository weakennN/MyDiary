package MyDiary.Core;

import MyDiary.Common.SceneContentChanger;
import MyDiary.Core.Content.MainContent;
import MyDiary.Database.Database;
import MyDiary.Core.Diary.Diary.Diary;
import MyDiary.Core.Entry.LoginSystem.LoginSystem;

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

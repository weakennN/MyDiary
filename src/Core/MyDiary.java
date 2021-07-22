package Core;

import Common.SceneContentChanger;
import Content.MainContent;
import Database.Database;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import LoginSystem.LoginSystem;
import UI.CustomControls.NoteControl.Month;

public class MyDiary {

    private LoginSystem loginSystem;
    private Diary diary;

    public MyDiary() {
    }

    public void start() {
        Database.makeConnection();
        this.setDiary(new Diary(1));
        diary.addNote(new Note(1,"Friday", 2021, Month.JULY, "title", "text"));
        // this.loginSystem = new LoginSystem(this);
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

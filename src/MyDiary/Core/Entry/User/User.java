package MyDiary.Core.Entry.User;

import MyDiary.Core.Diary.Diary.Diary;

public class User {

    private int id;
    private String username;
    private Diary diary;

    public User(int id, String username, Diary diary) {
        this.id = id;
        this.username = username;
        this.diary = diary;
    }

    public Diary getDiary() {
        return this.diary;
    }
}

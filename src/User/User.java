package User;

import Diary.Diary.Diary;

public class User {

    private String id;
    private String username;
    private Diary diary;

    public User(String id, String username, Diary diary) {
        this.id = id;
        this.username = username;
        this.diary = diary;
    }

    public Diary getDiary() {
        return this.diary;
    }
}

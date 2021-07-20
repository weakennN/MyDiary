package Core;

import Database.Database;
import LoginSystem.LoginSystem;

public class MyDiary {

    private LoginSystem loginSystem;

    public MyDiary() {
    }

    public void start() {
        Database.makeConnection();
        this.loginSystem = new LoginSystem();
    }

    public void stop() {
        Database.closeConnection();
    }
}

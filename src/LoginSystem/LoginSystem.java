package LoginSystem;

import Core.MyDiary;
import UI.Designer;
import javafx.scene.Parent;

public class LoginSystem {

    private Login login;
    private Register register;
    private MyDiary myDiary;

    public LoginSystem(MyDiary myDiary) {
        this.init();
        this.myDiary = myDiary;
    }

    private void init() {
        this.login = new Login(this);
        this.register = new Register(this);
        Designer.setSceneRoot(this.login);
    }

    public Register getRegister() {
        return this.register;
    }

    public void changeContent(Parent parent) {
        Designer.setSceneRoot(parent);
    }

    public MyDiary getMyDiary() {
        return this.myDiary;
    }
}

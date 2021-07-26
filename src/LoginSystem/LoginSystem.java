package LoginSystem;

import Core.MyDiary;
import LoginSystem.Login.Login;
import LoginSystem.Register.Register;
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
        Designer.initScene(this.login);
    }

    public Register getRegister() {
        return this.register;
    }

    public Login getLogin() {
        return this.login;
    }

    public void changeContent(Parent parent) {
        Designer.setSceneRoot(parent);
    }

    public MyDiary getMyDiary() {
        return this.myDiary;
    }
}

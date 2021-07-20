package LoginSystem;

import UI.Designer;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginSystem {

    private Login login;
    private Register register;
    private Scene scene;

    public LoginSystem() {
        this.init();
    }

    private void init() {
        this.login = new Login(this);
        this.register = new Register(this);
        this.scene = new Scene(this.login);
        Designer.changeScene(this.scene);
    }

    public Register getRegister() {
        return this.register;
    }

    public void changeContent(Parent parent) {
        this.scene.setRoot(parent);
    }
}

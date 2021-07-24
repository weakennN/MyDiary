package LoginSystem.Login;

import LoginSystem.LoginSystem;

public class Login extends LoginDesigner {

    private LoginSystem loginSystem;

    public Login(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
        this.init();
    }

    private void init() {
        super.getCreateAccountButton().setOnAction(e -> {
            this.loginSystem.changeContent(this.loginSystem.getRegister());
        });
    }
}

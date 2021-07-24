package LoginSystem.Login;

import UI.CustomControls.DataField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LoginDesigner extends Pane {

    private DataField emailField;
    private DataField passwordField;
    private Button createAccountButton;
    private Button loginButton;

    public LoginDesigner() {
        this.initStyle();
    }

    private void initStyle() {
        this.emailField = new DataField(new TextField(), "Email");
        this.passwordField = new DataField(new PasswordField(), "Password");
        this.createAccountButton = new Button("Create new account");
        this.loginButton = new Button("Login");

        VBox container = new VBox(10);
        container.getChildren().addAll(this.emailField, this.passwordField, this.createAccountButton, this.loginButton);
        super.getChildren().add(container);
        super.setMinSize(700, 550);
    }

    public DataField getEmailField() {
        return emailField;
    }

    public DataField getPasswordField() {
        return passwordField;
    }

    public Button getCreateAccountButton() {
        return createAccountButton;
    }

    public Button getLoginButton() {
        return loginButton;
    }
}

package LoginSystem;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Login extends Pane {

    private LoginSystem loginSystem;
    private TextField emailField;
    private TextField passwordField;
    private Button loginButton;
    private Button createAccountButton;

    public Login(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
        this.init();
    }

    private void init() {
        this.emailField = new TextField();
        this.passwordField = new TextField();
        this.loginButton = new Button("Login");
        this.createAccountButton = new Button("Create new account");
        this.emailField.setPromptText("Email");
        this.passwordField.setPromptText("Password");

        VBox fieldVBox = new VBox(10);
        fieldVBox.getChildren().addAll(this.emailField, this.passwordField, this.loginButton, this.createAccountButton);

        this.createAccountButton.setOnAction(e -> {
            this.loginSystem.changeContent(this.loginSystem.getRegister());
        });

        super.setMinSize(1000, 600);
        super.getChildren().addAll(fieldVBox);
    }
}

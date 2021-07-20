package LoginSystem;

import Database.Database;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Register extends Pane {

    private LoginSystem loginSystem;

    private TextField usernameField;
    private TextField emailField;
    private TextField passwordField;
    private Button registerButton;

    public Register(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
        this.init();
    }

    private void init() {
        this.usernameField = new TextField();
        this.emailField = new TextField();
        this.passwordField = new TextField();

        this.usernameField.setPromptText("Username");
        this.emailField.setPromptText("Email");
        this.passwordField.setPromptText("Password");

        this.registerButton = new Button("Register");

        this.registerButton.setOnAction(e -> {
            Database.createUser(3,"hello","hi","yo",3);
        });
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(this.usernameField, this.emailField, this.passwordField, this.registerButton);

        super.setMinSize(1000, 600);
        super.getChildren().addAll(vBox);
    }
}

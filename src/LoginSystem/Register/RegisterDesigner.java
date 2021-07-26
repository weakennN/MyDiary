package LoginSystem.Register;

import LoginSystem.Entry;
import UI.CustomControls.DataField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterDesigner extends Entry {

    private DataField usernameField;
    private DataField emailField;
    private DataField passwordField;
    private Button registerButton;
    private Button goBackToLoginButton;

    public RegisterDesigner() {
        this.init();
    }

    private void init() {
        this.usernameField = new DataField(new TextField(), "Username");
        this.emailField = new DataField(new TextField(), "Email");
        this.passwordField = new DataField(new PasswordField(), "Password");
        this.registerButton = new Button("Register");
        this.goBackToLoginButton = new Button("Already have an account ?");

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(this.usernameField, this.emailField, this.passwordField, this.registerButton, this.goBackToLoginButton);

        vBox.setLayoutX(200);
        vBox.setLayoutY(142.5);
        super.getChildren().add(vBox);

        super.setMinSize(700, 550);
    }

    public void removeErrorMessages() {
        this.usernameField.removeErrorMessage();
        this.emailField.removeErrorMessage();
        this.passwordField.removeErrorMessage();
    }

    public DataField getUsernameField() {
        return this.usernameField;
    }

    public DataField getEmailField() {
        return this.emailField;
    }

    public DataField getPasswordField() {
        return this.passwordField;
    }

    public Button getRegisterButton() {
        return this.registerButton;
    }

    public Button getGoBackToLoginButton() {
        return this.goBackToLoginButton;
    }
}

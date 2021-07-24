package LoginSystem.Register;

import UI.CustomControls.DataField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RegisterDesigner extends Pane {

    private DataField usernameField;
    private DataField emailField;
    private DataField passwordField;
    private Button registerButton;

    public RegisterDesigner() {
        this.init();
    }

    private void init() {
        this.usernameField = new DataField(new TextField(), "Username");
        this.emailField = new DataField(new TextField(), "Email");
        this.passwordField = new DataField(new PasswordField(), "Password");
        this.registerButton = new Button("Register");

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(this.usernameField, this.emailField, this.passwordField, this.registerButton);

        vBox.setLayoutX(200);
        vBox.setLayoutY(142.5);
        super.getChildren().add(vBox);

        super.setMinSize(700, 550);
    }

    public Button getRegisterButton() {
        return this.registerButton;
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
}

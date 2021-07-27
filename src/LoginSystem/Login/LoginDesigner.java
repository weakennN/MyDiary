package LoginSystem.Login;

import LoginSystem.Entry;
import UI.CustomControls.DataField;
import UI.CustomControls.EButton;
import UI.CustomControls.EHyperLink;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginDesigner extends Entry {

    private DataField emailField;
    private DataField passwordField;
    private EButton loginButton;
    private EHyperLink createAccountHyperLink;

    public LoginDesigner() {
        this.initStyle();
    }

    private void initStyle() {
        this.emailField = new DataField(new TextField(), "Email");
        this.passwordField = new DataField(new PasswordField(), "Password");
        this.loginButton = new EButton("Login");
        this.createAccountHyperLink = new EHyperLink("Create new account");

        VBox container = new VBox(10);
        container.getChildren().addAll(this.emailField, this.passwordField, this.createAccountHyperLink, this.loginButton);
        container.setLayoutX(200);
        container.setLayoutY(130);
        super.getChildren().add(container);
        super.setMinSize(700, 550);
    }

    public DataField getEmailField() {
        return emailField;
    }

    public DataField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public EHyperLink getCreateAccountHyperLink() {
        return this.createAccountHyperLink;
    }

    public void removeErrorMessages() {
        this.emailField.removeErrorMessage();
        this.passwordField.removeErrorMessage();
    }
}

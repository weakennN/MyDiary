package LoginSystem;

import Common.IdGenerator;
import Database.Database;
import Diary.Diary.Diary;
import UI.CustomControls.DataField;
import User.User;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Register extends Pane {

    private LoginSystem loginSystem;

    private DataField usernameField;
    private DataField emailField;
    private DataField passwordField;
    private Button registerButton;

    public Register(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
        this.initStyle();
    }
    // TODO create register designer and login designer
    private void initStyle() {
        this.usernameField = new DataField(new TextField(), "Username");
        this.emailField = new DataField(new TextField(), "Email");
        this.passwordField = new DataField(new PasswordField(), "Password");
        this.passwordField.displayErrorMessage("Must be 6 or more in lenght");
        this.registerButton = new Button("Register");

        this.registerButton.setOnAction(e -> {
            // TODO: verify data about the user if its correct
            int id = IdGenerator.generateId();
            User user = new User(id, this.usernameField.getTextField().getText(), new Diary(id));
            Database.createUser(id, this.usernameField.getTextField().getText(),
                    this.emailField.getTextField().getText(), this.passwordField.getTextField().getText(),
                    id);
            this.loginSystem.getMyDiary().setDiary(user.getDiary());
            // TODO set current user to this user
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(this.usernameField, this.emailField, this.passwordField, this.registerButton);

        super.getChildren().add(vBox);

        super.setMinSize(700, 550);
    }
}

package LoginSystem;

import Common.IdGenerator;
import Database.Database;
import Diary.Diary.Diary;
import UI.CustomControls.DataField;
import User.User;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.util.List;

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

    private void initStyle() {
        this.usernameField = new DataField("test");
        this.emailField = new DataField("123");
        this.passwordField = new DataField("dsf");

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

        List<DataField> dataFields = List.of(this.usernameField, this.emailField, this.passwordField);

        double y = 185;
        for (DataField dataField : dataFields) {
            dataField.setLayoutX(350 - (dataField.getTextField().getMinWidth() / 2));
            dataField.setLayoutY(y);
            y += dataField.getTextField().getMinHeight() + 10;
            super.getChildren().add(dataField);
        }

        this.registerButton.setLayoutX(350);
        this.registerButton.setLayoutY(y);
        super.getChildren().add(this.registerButton);

        super.setMinSize(700, 550);
    }
}

package LoginSystem.Register;

import Database.*;
import Diary.Diary.Diary;
import LoginSystem.LoginSystem;
import LoginSystem.Verifier.RegisterEmailVerifier;
import LoginSystem.Verifier.RegisterPasswordVerifier;
import LoginSystem.Verifier.UsernameVerifier;
import LoginSystem.Verifier.Verifier;
import User.User;

public class Register extends RegisterDesigner {

    public Register(LoginSystem loginSystem) {
        super();
        super.setLoginSystem(loginSystem);
        this.init();
    }

    private void init() {
        super.addVerifier(new UsernameVerifier<>(super.getUsernameField()));
        super.addVerifier(new RegisterPasswordVerifier<>(super.getPasswordField()));
        super.addVerifier(new RegisterEmailVerifier<>(super.getEmailField()));

        super.getRegisterButton().setOnAction(e -> {
            super.removeErrorMessages();

            boolean ableToRegister = true;
            for (Verifier verifier : super.getVerifiers()) {
                if (!verifier.verify()) {
                    ableToRegister = false;
                }
            }

            if (ableToRegister) {
                // TODO first register without diary id and then set the diary id user_id = diary_id
                // TODO: getter for diary_id, note_id
                UserManagement.createUser(super.getUsernameField().getTextField().getText(),
                        super.getEmailField().getTextField().getText(), super.getPasswordField().getTextField().getText());
                int id = UserManagement.getUserId(super.getEmailField().getTextField().getText());
                User user = new User(id, super.getUsernameField().getTextField().getText(), new Diary(id));
                UserManagement.setDiaryId(id);
                super.getLoginSystem().getMyDiary().setDiary(user.getDiary());
            }
        });

        super.getGoBackToLoginHyperLink().setOnAction(e -> {
            super.getLoginSystem().changeContent(super.getLoginSystem().getLogin());
        });
    }
}

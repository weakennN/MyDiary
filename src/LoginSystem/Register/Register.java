package LoginSystem.Register;

import Database.Database;
import Diary.Diary.Diary;
import LoginSystem.LoginSystem;
import LoginSystem.Verifier.RegisterEmailVerifier;
import LoginSystem.Verifier.RegisterPasswordVerifier;
import LoginSystem.Verifier.UsernameVerifier;
import LoginSystem.Verifier.Verifier;
import User.User;

import java.util.UUID;

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
            super.getEmailField().removeErrorMessage();
            super.getPasswordField().removeErrorMessage();
            super.getUsernameField().removeErrorMessage();

            boolean ableToRegister = true;
            for (Verifier verifier : super.getVerifiers()) {
                if (!verifier.verify()) {
                    ableToRegister = false;
                }
            }

            if (ableToRegister) {
                String userId = UUID.randomUUID().toString();
                String diaryId = UUID.randomUUID().toString();
                User user = new User(UUID.randomUUID().toString(), super.getUsernameField().getTextField().getText(), new Diary(diaryId));
                Database.createUser(userId, super.getUsernameField().getTextField().getText(),
                        super.getEmailField().getTextField().getText(), super.getPasswordField().getTextField().getText(),
                        diaryId);
                super.getLoginSystem().getMyDiary().setDiary(user.getDiary());
            }
        });
    }
}

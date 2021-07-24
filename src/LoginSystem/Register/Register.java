package LoginSystem.Register;

import Database.Database;
import Diary.Diary.Diary;
import LoginSystem.LoginSystem;
import LoginSystem.Verifier.RegisterEmailVerifier;
import LoginSystem.Verifier.RegisterPasswordVerifier;
import LoginSystem.Verifier.UsernameVerifier;
import LoginSystem.Verifier.Verifier;
import User.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Register extends RegisterDesigner {

    private LoginSystem loginSystem;
    private List<Verifier> verifiers;

    public Register(LoginSystem loginSystem) {
        super();
        this.loginSystem = loginSystem;
        this.verifiers = new ArrayList<>();
        this.init();
    }

    private void init() {
        this.verifiers.add(new UsernameVerifier<>(super.getUsernameField()));
        this.verifiers.add(new RegisterPasswordVerifier<>(super.getPasswordField()));
        this.verifiers.add(new RegisterEmailVerifier<>(super.getEmailField()));

        super.getRegisterButton().setOnAction(e -> {
            super.getEmailField().removeErrorMessage();
            super.getPasswordField().removeErrorMessage();
            super.getUsernameField().removeErrorMessage();

            boolean ableToRegister = true;
            for (Verifier verifier : this.verifiers) {
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
                this.loginSystem.getMyDiary().setDiary(user.getDiary());
            }
        });
    }
}

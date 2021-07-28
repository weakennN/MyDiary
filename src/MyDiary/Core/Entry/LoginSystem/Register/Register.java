package MyDiary.Core.Entry.LoginSystem.Register;

import MyDiary.Core.Diary.Diary.Diary;
import MyDiary.Core.Entry.LoginSystem.LoginSystem;
import MyDiary.Core.Entry.LoginSystem.Verifier.*;
import MyDiary.Database.UserManagement;
import MyDiary.Core.Entry.User.User;

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
                UserManagement.createUser(super.getUsernameField().getTextField().getText(),
                        super.getEmailField().getTextField().getText(), super.getPasswordField().getTextField().getText());
                int id = UserManagement.getUserId(super.getEmailField().getTextField().getText());
                User user = new User(id, super.getUsernameField().getTextField().getText(), new Diary(id));
                super.getLoginSystem().getMyDiary().setDiary(user.getDiary());
            }
        });

        super.getGoBackToLoginHyperLink().setOnAction(e -> {
            super.getLoginSystem().changeContent(super.getLoginSystem().getLogin());
        });
    }
}

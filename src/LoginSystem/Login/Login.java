package LoginSystem.Login;

import Database.*;
import LoginSystem.Loader.DiaryLoader;
import LoginSystem.Loader.Loader;
import LoginSystem.LoginSystem;
import LoginSystem.Verifier.LoginEmailVerifier;
import LoginSystem.Verifier.LoginPasswordVerifier;
import LoginSystem.Verifier.Verifier;

import java.util.ArrayList;
import java.util.List;

public class Login extends LoginDesigner {

    private List<Loader> loaders;

    public Login(LoginSystem loginSystem) {
        super();
        super.setLoginSystem(loginSystem);
        this.loaders = new ArrayList<>();
        this.init();
    }

    private void init() {
        super.addVerifier(new LoginEmailVerifier<>(super.getEmailField()));
        super.addVerifier(new LoginPasswordVerifier<>(super.getPasswordField(), super.getEmailField()));

        super.getCreateAccountHyperLink().setOnAction(e -> {
            super.getLoginSystem().changeContent(super.getLoginSystem().getRegister());
        });

        super.getLoginButton().setOnAction(e -> {
            super.removeErrorMessages();
            boolean ableToLogin = true;

            for (Verifier verifier : super.getVerifiers()) {
                if (!verifier.verify()) {
                    ableToLogin = false;
                }
            }

            if (ableToLogin) {
                int diaryId = DiaryManagement.getDiaryId(super.getEmailField().getTextField().getText());
                this.loaders.add(new DiaryLoader(super.getLoginSystem().getMyDiary(), diaryId));
                for (Loader loader : this.loaders) {
                    loader.load();
                }
            }
        });
    }
}

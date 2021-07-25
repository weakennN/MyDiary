package LoginSystem;

import LoginSystem.Verifier.Verifier;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Entry extends Pane {

    private List<Verifier> verifiers;
    private LoginSystem loginSystem;

    public Entry() {
        this.verifiers = new ArrayList<>();
    }

    public void addVerifier(Verifier verifier) {
        this.verifiers.add(verifier);
    }

    public List<Verifier> getVerifiers() {
        return this.verifiers;
    }

    public LoginSystem getLoginSystem() {
        return this.loginSystem;
    }

    public void setLoginSystem(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
    }
}

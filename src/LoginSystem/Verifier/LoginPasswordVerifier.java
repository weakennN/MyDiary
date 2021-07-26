package LoginSystem.Verifier;

import Database.Database;
import UI.CustomControls.DataField;

public class LoginPasswordVerifier<T> extends Verifier<T> {

    private T secondItem;

    public LoginPasswordVerifier(T first, T secondItem) {
        super(first);
        this.secondItem = secondItem;
    }

    @Override
    public boolean verify() {
        DataField passwordField = (DataField) super.getItem();
        DataField emailField = (DataField) this.secondItem;

        if (!Database.isPasswordCorrect(emailField.getTextField().getText(), passwordField.getTextField().getText())) {
            passwordField.displayErrorMessage(" - Invalid password");
            return false;
        }

        return true;
    }
}

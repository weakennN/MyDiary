package LoginSystem.Verifier;


import Database.Database;
import UI.CustomControls.DataField;

public class UsernameVerifier<T> extends Verifier<T> {

    public UsernameVerifier(T item) {
        super(item);
    }

    @Override
    public boolean verify() {
        DataField dataField = (DataField) super.getItem();

        if (!validateLength(dataField.getTextField().getText())) {
            dataField.displayErrorMessage(" - Must be 6 or more in length");
            return false;
        }

        if (!isUsernameAvailable(dataField.getTextField().getText())) {
            dataField.displayErrorMessage(" - The username is already taken");
            return false;
        }

        return true;
    }

    private boolean validateLength(String username) {
        return username.length() >= 6;
    }

    private boolean isUsernameAvailable(String username) {
        return Database.isUsernameAvailable(username);
    }
}

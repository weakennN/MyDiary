package MyDiary.Core.Entry.LoginSystem.Verifier;

import MyDiary.UI.CustomControls.DataField;

public class RegisterPasswordVerifier<T> extends Verifier<T> {

    public RegisterPasswordVerifier(T item) {
        super(item);
    }

    @Override
    public boolean verify() {
        DataField dataField = (DataField) super.getItem();

        if (!validateLength(dataField.getTextField().getText())) {
            dataField.displayErrorMessage(" - Must be 6 or more in length");
            return false;
        }

        return true;
    }

    private boolean validateLength(String password) {
        return password.length() >= 6;
    }
}

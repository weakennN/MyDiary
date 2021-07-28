package MyDiary.Core.Entry.LoginSystem.Verifier;

import MyDiary.Database.UserManagement;
import MyDiary.UI.CustomControls.DataField;

public class LoginEmailVerifier<T> extends Verifier<T> {

    public LoginEmailVerifier(T item) {
        super(item);
    }

    @Override
    public boolean verify() {
        DataField dataField = (DataField) super.getItem();

        if (UserManagement.isEmailAvailable(dataField.getTextField().getText())) {
            dataField.displayErrorMessage(" - Invalid email");
            return false;
        }

        return true;
    }
}

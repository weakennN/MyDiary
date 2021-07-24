package LoginSystem.Verifier;

import UI.CustomControls.DataField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterEmailVerifier<T> extends Verifier<T> {

    public RegisterEmailVerifier(T item) {
        super(item);
    }

    @Override
    public boolean verify() {
        DataField dataField = (DataField) super.getItem();

        if (!isValid(dataField.getTextField().getText())) {
            dataField.displayErrorMessage(" - Invalid email");
            return false;
        }
        // TODO: check if this email already exists
        return true;
    }

    private boolean isValid(String email) {
        Pattern pattern = Pattern.compile("^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}

package Action;

import javafx.scene.control.Button;

public abstract class ButtonAction extends Action {

    private Button button;

    public ButtonAction(Button button) {
        super();
        this.button = button;
    }

    public Button getButton() {
        return this.button;
    }
}

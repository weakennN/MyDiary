package UI;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Designer {

    public static Stage stage;

    public static void init() {
        stage = new Stage();
    }

    public static void changeScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}

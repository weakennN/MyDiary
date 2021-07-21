package UI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Designer {

    public static Stage stage;
    public static Scene scene;

    public static void init() {
        stage = new Stage();
    }

    public static void changeScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }

    public static void setSceneRoot(Parent parent) {
        scene = new Scene(parent);
        changeScene(scene);
    }
}

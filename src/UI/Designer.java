package UI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Designer {

    public static Stage stage;
    public static Scene scene;

    public static void init() {
        stage = new Stage();
    }

    public static void changeScene() {
        stage.sizeToScene();
    }

    public static void setSceneRoot(Parent parent) {
        scene.setRoot(parent);
        changeScene();
    }

    public static void initScene(Parent parent) {
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}

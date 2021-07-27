package UI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Designer {

    public static Stage stage;
    public static Scene scene;

    public static void init() {
        stage = new Stage();
        stage.setResizable(false);
    }

    public static void changeScene() {
        stage.sizeToScene();
    }

    public static void setSceneRoot(Parent parent) {
        scene.setRoot(parent);
        changeScene();
    }

    public static void initScene(Region parent) {
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}

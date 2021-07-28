package MyDiary;

import MyDiary.Core.MyDiary;
import MyDiary.UI.Designer;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Designer.init();
        MyDiary myDiary = new MyDiary();
        Designer.stage.setOnCloseRequest(e -> {
            myDiary.stop();
        });
        myDiary.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package Content;

import Diary.Diary.Diary;
import javafx.scene.layout.Region;

public class MainContent extends Region {

    private Diary diary;

    public MainContent(Diary diary) {
        this.diary = diary;
        this.init();
    }

    private void init() {
        super.getChildren().add(this.diary);
    }
}

package Content;

import Common.SceneContentChanger;
import Diary.Diary.Diary;
import Diary.Searcher.Searcher;
import UI.CustomControls.NoteMenuControls.NoteMenuButton;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MainContent extends Region {

    private Diary diary;
    private NoteMenuButton modifyNote;
    private Searcher searcher;

    public MainContent(Diary diary) {
        this.diary = diary;
        this.searcher = new Searcher(this.diary);
        this.init();
    }

    private void init() {
        this.modifyNote = new NoteMenuButton();
        SceneContentChanger.addContent("noteMenu", new NoteMenu(this.diary));
        this.modifyNote.setLayoutX(800);
        this.modifyNote.setLayoutY(550);
        this.modifyNote.setOnAction(e -> {
            ((NoteMenu) SceneContentChanger.getContent("noteMenu")).getNoteCreator().clearFields();
            ((NoteMenu) SceneContentChanger.getContent("noteMenu")).getNoteCreator().setCreateAction();
            SceneContentChanger.changeContent("noteMenu");
        });
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(this.searcher, this.diary);
        super.getChildren().addAll(vBox, this.modifyNote);
    }
}

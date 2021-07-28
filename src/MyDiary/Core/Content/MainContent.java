package MyDiary.Core.Content;

import MyDiary.Common.SceneContentChanger;
import MyDiary.Core.Diary.Diary.Diary;
import MyDiary.Core.Diary.Searcher.Searcher;
import MyDiary.UI.CustomControls.EButton;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MainContent extends Region {

    private Diary diary;
    private EButton modifyNote;
    private Searcher searcher;

    public MainContent(Diary diary) {
        this.diary = diary;
        this.searcher = new Searcher(this.diary);
        this.init();
    }

    private void init() {
        this.modifyNote = new EButton("Create Note");
        this.modifyNote.setMinSize(80,45);
        SceneContentChanger.addContent("noteMenu", new NoteMenu(this.diary));
        this.modifyNote.setLayoutX(770);
        this.modifyNote.setLayoutY(575);
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

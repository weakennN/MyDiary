package Content;

import Common.SceneContentChanger;
import Diary.Diary.Diary;
import UI.CustomControls.NoteMenuControls.NoteMenuButton;
import javafx.scene.layout.Region;

public class MainContent extends Region {

    private Diary diary;
    private NoteMenuButton modifyNote;

    public MainContent(Diary diary) {
        this.diary = diary;
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
        super.getChildren().addAll(this.diary, this.modifyNote);
    }
}

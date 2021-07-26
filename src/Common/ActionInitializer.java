package Common;

import Content.NoteMenu;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import UI.Designer;
import javafx.scene.input.MouseButton;

public class ActionInitializer {

    public static void initNoteDefaultActions(Note note, Diary diary) {
        note.setOnMouseClicked(e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)) {
                ((NoteMenu) SceneContentChanger.getContent("noteMenu")).getNoteCreator().setFields(note);
                SceneContentChanger.changeContent("noteMenu");
                ((NoteMenu) SceneContentChanger.getContent("noteMenu")).getNoteCreator().setEditAction();
            } else if (e.getButton().equals(MouseButton.SECONDARY)) {
                diary.getMenu("NoteContextMenu").show(Designer.stage, e.getScreenX(), e.getScreenY());
            }
            NoteClicked.note = note;
        });
    }
}

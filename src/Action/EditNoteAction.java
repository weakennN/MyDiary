package Action;

import Common.NoteClicked;
import Common.SceneContentChanger;
import Diary.Notes.Note;
import Diary.Notes.NoteCreator.NoteCreator;
import javafx.scene.control.Button;

public class EditNoteAction extends NoteCreatorAction{

    public EditNoteAction(Button button, NoteCreator noteCreator) {
        super(button, noteCreator);
    }

    @Override
    public void initAction() {
        super.getButton().setOnAction(e -> {
            Note note = super.getNoteCreator().createNote();
            super.getNoteCreator().getDiary().changeNode(NoteClicked.note,note);
            SceneContentChanger.changeContent("mainContent");
        });
    }
}

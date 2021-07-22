package Action;

import Common.NoteClicked;
import Common.SceneContentChanger;
import Diary.Notes.Note;
import Diary.Notes.NoteCreator.NoteCreator;
import javafx.scene.control.Button;

public class CreateNoteAction extends NoteCreatorAction {

    public CreateNoteAction(Button button, NoteCreator noteCreator) {
        super(button, noteCreator);
    }

    @Override
    public void initAction() {

        super.getButton().setOnAction(e -> {
            Note note = super.getNoteCreator().createNote();
            super.getNoteCreator().getDiary().addNote(note);
            super.getNoteCreator().clearFields();
            SceneContentChanger.changeContent("mainContent");
            note.setOnMouseClicked(r -> {
                NoteClicked.note = note;
                super.getNoteCreator().getAction("edit").initAction();
                SceneContentChanger.changeContent("noteMenu");
            });
        });
    }
}

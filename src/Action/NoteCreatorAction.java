package Action;

import Diary.Notes.NoteCreator.NoteCreator;
import javafx.scene.control.Button;

public abstract class NoteCreatorAction extends ButtonAction {

    private NoteCreator noteCreator;

    public NoteCreatorAction(Button button, NoteCreator noteCreator) {
        super(button);
        this.noteCreator = noteCreator;
    }

    public NoteCreator getNoteCreator() {
        return this.noteCreator;
    }
}

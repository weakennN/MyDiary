package RightClickMenu.MenuItem;

import Common.NoteClicked;
import Database.Database;
import Diary.Diary.Diary;

public class RemoveNote extends DiaryMenuItem {

    public RemoveNote(Diary diary) {
        super(diary);
        super.setText("RemoveNote");
    }

    @Override
    public void doAction() {
        super.setOnAction(e -> {
            Database.removeNote(NoteClicked.note.getUniqueId());
            super.getDiary().removeNote(NoteClicked.note);
        });
    }
}
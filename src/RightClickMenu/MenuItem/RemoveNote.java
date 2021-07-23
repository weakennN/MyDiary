package RightClickMenu.MenuItem;

import Common.NoteClicked;
import Diary.Diary.Diary;

public class RemoveNote extends DiaryMenuItem {

    public RemoveNote(Diary diary) {
        super(diary);
        super.setText("RemoveNote");
    }

    @Override
    public void doAction() {
        super.setOnAction(e -> {
            super.getDiary().removeNote(NoteClicked.note);
        });
    }
}

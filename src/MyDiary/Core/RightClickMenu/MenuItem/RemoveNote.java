package MyDiary.Core.RightClickMenu.MenuItem;

import MyDiary.Common.NoteClicked;
import MyDiary.Core.Diary.Diary.Diary;
import MyDiary.Database.DiaryManagement;

public class RemoveNote extends DiaryMenuItem {

    public RemoveNote(Diary diary) {
        super(diary);
        super.setText("RemoveNote");
    }

    @Override
    public void doAction() {
        super.setOnAction(e -> {
            DiaryManagement.removeNote(NoteClicked.note.getUniqueId());
            super.getDiary().removeNote(NoteClicked.note);
        });
    }
}

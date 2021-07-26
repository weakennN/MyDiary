package LoginSystem.Loader;

import Common.ActionInitializer;
import Common.NoteClicked;
import Common.SceneContentChanger;
import Content.NoteMenu;
import Core.MyDiary;
import Database.Database;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import UI.CustomControls.NoteControl.Month;
import UI.Designer;
import javafx.scene.input.MouseButton;

import java.util.List;
import java.util.Map;

public class DiaryLoader extends Loader {

    private String diaryId;

    public DiaryLoader(MyDiary myDiary, String diaryId) {
        super(myDiary);
        this.diaryId = diaryId;
    }

    @Override
    public void load() {
        Diary diary = new Diary(this.diaryId);

        Map<String, List<String>> registeredNotes = Database.getAllRegisteredNotes(this.diaryId);

        for (Map.Entry<String, List<String>> entry : registeredNotes.entrySet()) {
            String noteId = entry.getKey();
            String title = entry.getValue().get(0);
            String text = entry.getValue().get(1);
            String weekDay = entry.getValue().get(2);
            int monthDay = Integer.parseInt(entry.getValue().get(3));
            String month = entry.getValue().get(4);
            int year = Integer.parseInt(entry.getValue().get(5));
            Note note = new Note(noteId, monthDay, weekDay, year, Month.findByName(month), title, text);
            ActionInitializer.initNoteDefaultActions(note, diary);
            diary.addNote(note);
        }

        super.getMyDiary().setDiary(diary);
    }
}

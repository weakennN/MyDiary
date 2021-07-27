package LoginSystem.Loader;

import Common.ActionInitializer;
import Core.MyDiary;
import Database.*;
import Diary.Diary.Diary;
import Diary.Notes.Note;
import UI.CustomControls.NoteControl.Month;

import java.util.List;
import java.util.Map;

public class DiaryLoader extends Loader {

    private int diaryId;

    public DiaryLoader(MyDiary myDiary, int diaryId) {
        super(myDiary);
        this.diaryId = diaryId;
    }

    @Override
    public void load() {
        Diary diary = new Diary(this.diaryId);

        Map<Integer, List<String>> registeredNotes = DiaryManagement.getAllRegisteredNotes(this.diaryId);

        for (Map.Entry<Integer, List<String>> entry : registeredNotes.entrySet()) {
            int noteId = entry.getKey();
            String title = entry.getValue().get(0);
            String text = entry.getValue().get(1);
            String weekDay = entry.getValue().get(2);
            int monthDay = Integer.parseInt(entry.getValue().get(3));
            String month = entry.getValue().get(4);
            int year = Integer.parseInt(entry.getValue().get(5));
            Note note = new Note(monthDay, weekDay, year, Month.findByName(month), title, text);
            note.setId(noteId);
            ActionInitializer.initNoteDefaultActions(note, diary);
            diary.addNote(note);
        }

        super.getMyDiary().setDiary(diary);
    }
}

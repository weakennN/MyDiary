package MyDiary.Core.Diary.Searcher;

import MyDiary.Database.DiaryManagement;
import MyDiary.Core.Diary.Diary.Diary;
import MyDiary.Core.Diary.Notes.Note;

import java.util.ArrayList;
import java.util.List;

public class Searcher extends SearcherDesigner {

    private Diary diary;

    public Searcher(Diary diary) {
        super();
        this.diary = diary;
        this.init();
    }

    private void init() {
        this.initActions();
    }

    private void initActions() {
        this.searchAction();
        super.getSearcherControl().getTextField().setOnKeyTyped(e -> {
            this.searchAction();
        });

        // set the textField to change action on mouse clicked as well maybe
    }

    private void search() {
        List<Integer> ids = DiaryManagement.getNoteIds(super.getSearcherControl().getTextField().getText(), this.diary.getUniqueId());
        List<Note> notes = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            notes.add(this.diary.getNote(ids.get(i)));
        }
        this.diary.setNotes(notes);
    }

    private void cancelSearch() {
        this.diary.resetNotes();
    }

    private void searchAction() {
        super.getSearcherControl().getButton().setText("Search");
        super.getSearcherControl().getButton().setOnAction(e -> {
            this.search();
            this.setCancelSearchAction();
        });
    }

    private void setCancelSearchAction() {
        super.getSearcherControl().getButton().setText("Cancel");
        super.getSearcherControl().getButton().setOnAction(e -> {
            this.cancelSearch();
            this.searchAction();
            super.getSearcherControl().getTextField().setText("");
        });
    }
}

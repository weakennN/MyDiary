package Content;

import Diary.Diary.Diary;
import Diary.Notes.NoteCreator.NoteCreator;
import javafx.scene.layout.Region;

public class NoteMenu extends Region {

    private NoteCreator noteCreator;

    public NoteMenu(Diary diary) {
        this.noteCreator = new NoteCreator(diary);
        super.setMinSize(600, 600);
        super.setMaxSize(600, 600);
        super.setPrefSize(600, 600);
        this.initStyle();
    }

    private void initStyle() {
        super.getChildren().add(this.noteCreator);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 600;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 600;
    }

    public NoteCreator getNoteCreator() {
        return this.noteCreator;
    }
}

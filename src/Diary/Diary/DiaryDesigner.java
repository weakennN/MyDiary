package Diary.Diary;

import Diary.Notes.Note;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class DiaryDesigner extends ScrollPane {

    private VBox notesContainer;

    public DiaryDesigner() {
        this.initStyle();
    }

    private void initStyle() {
        this.notesContainer = new VBox();
        this.notesContainer.setMaxWidth(900);
        super.setContent(this.notesContainer);
        super.setHbarPolicy(ScrollBarPolicy.NEVER);
    }

    public void addToContainer(Note note) {
        this.notesContainer.getChildren().add(note);
    }

    public void removeFromContainer(Note note) {
        this.notesContainer.getChildren().remove(note);
    }

    @Override
    protected double computePrefHeight(double width) {
        return 600;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 900;
    }
}

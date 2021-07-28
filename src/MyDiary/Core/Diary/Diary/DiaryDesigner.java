package MyDiary.Core.Diary.Diary;

import MyDiary.Core.Diary.Notes.Note;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DiaryDesigner extends ScrollPane {

    private VBox notesContainer;

    public DiaryDesigner() {
        this.initStyle();
    }

    private void initStyle() {
        this.notesContainer = new VBox(3);
        this.notesContainer.setMaxWidth(900);
        super.setContent(this.notesContainer);
        super.setHbarPolicy(ScrollBarPolicy.NEVER);
        super.setBackground(new Background(new BackgroundFill(Color.valueOf("fafaff"), null, null)));
        super.setStyle("-fx-background: #fafaff");
        super.getStyleClass().add("edge-to-edge");
    }

    public void addToContainer(Note note) {
        this.notesContainer.getChildren().add(note);
    }

    public void removeFromContainer(Note note) {
        this.notesContainer.getChildren().remove(note);
    }

    protected VBox getNotesContainer() {
        return this.notesContainer;
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

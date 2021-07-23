package Diary.Notes.NoteCreator;

import Diary.Notes.Note;
import UI.CustomControls.NoteMenuControls.CTextField;
import UI.CustomControls.NoteMenuControls.NTextArea;
import UI.CustomControls.NoteMenuControls.NoteMenuButton;
import UI.CustomControls.NoteMenuControls.TTextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Locale;

public abstract class NoteCreatorDesigner extends Region {

    private CTextField cTextField;
    private TTextField tTextField;
    private NTextArea nTextArea;
    private NoteMenuButton saveButton;
    private NoteMenuButton goBackButton;
    private VBox container;

    public NoteCreatorDesigner() {
        this.init();
    }

    private void init() {
        this.cTextField = new CTextField();
        this.tTextField = new TTextField();
        this.nTextArea = new NTextArea();
        this.container = new VBox(20);
        this.saveButton = new NoteMenuButton();
        this.saveButton.setText("Save");
        this.goBackButton = new NoteMenuButton();
        this.goBackButton.setText("Go back");
        HBox buttonHBox = new HBox(10);
        List<NoteMenuButton> buttons = List.of(this.saveButton, this.goBackButton);
        for (NoteMenuButton button : buttons) {
            buttonHBox.getChildren().add(button);
        }
        buttonHBox.setLayoutX(450);
        buttonHBox.setLayoutY(550);
        this.container.getChildren().addAll(this.cTextField, this.tTextField, this.nTextArea);
        this.container.setLayoutX(45);
        super.getChildren().addAll(this.container, buttonHBox);
    }

    public NoteMenuButton getSaveButton() {
        return this.saveButton;
    }

    public NoteMenuButton getGoBackButton() {
        return this.goBackButton;
    }

    public CTextField getCTextField() {
        return this.cTextField;
    }

    public TTextField getTTextField() {
        return this.tTextField;
    }

    public NTextArea getNTextArea() {
        return this.nTextArea;
    }

    public void clearFields() {
        this.cTextField.resetDate();
        this.tTextField.getTextField().setText("");
        this.nTextArea.getTextArea().setText("");
    }

    @Override
    protected double computePrefHeight(double width) {
        return 600;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 600;
    }

    public void setFields(Note note) {
        this.cTextField.getDatePicker().getEditor().setText(note.getWeekDay() + ", " + note.getMonthDay() + " "
                + note.getMonth().toString().charAt(0) + note.getMonth().toString().substring(1).toLowerCase(Locale.ROOT) + " " + note.getYear());
        this.tTextField.getTextField().setText(note.getTitle());
        this.nTextArea.getTextArea().setText(note.getText());
    }
}

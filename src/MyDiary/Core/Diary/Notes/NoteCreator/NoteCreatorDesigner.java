package MyDiary.Core.Diary.Notes.NoteCreator;

import MyDiary.Core.Diary.Notes.Note;
import MyDiary.UI.CustomControls.EButton;
import MyDiary.UI.CustomControls.NoteMenuControls.CTextField;
import MyDiary.UI.CustomControls.NoteMenuControls.NTextArea;
import MyDiary.UI.CustomControls.NoteMenuControls.TTextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class NoteCreatorDesigner extends Region {

    private CTextField cTextField;
    private TTextField tTextField;
    private NTextArea nTextArea;
    private EButton saveButton;
    private EButton goBackButton;
    private VBox container;

    public NoteCreatorDesigner() {
        this.init();
    }

    private void init() {
        this.cTextField = new CTextField();
        this.tTextField = new TTextField();
        this.nTextArea = new NTextArea();
        this.container = new VBox(20);
        this.saveButton = new EButton();
        this.saveButton.setText("Save");
        this.goBackButton = new EButton();
        this.goBackButton.setText("Go back");
        HBox buttonHBox = new HBox(10);
        List<EButton> buttons = List.of(this.saveButton, this.goBackButton);
        for (EButton button : buttons) {
            button.setMinSize(90, 45);
            buttonHBox.getChildren().add(button);
        }
        buttonHBox.setLayoutX(355);
        buttonHBox.setLayoutY(530);
        this.container.getChildren().addAll(this.cTextField, this.tTextField, this.nTextArea);
        this.container.setLayoutX(45);
        super.getChildren().addAll(this.container, buttonHBox);
    }

    public EButton getSaveButton() {
        return this.saveButton;
    }

    public EButton getGoBackButton() {
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

    public String getTitle() {
        return this.tTextField.getTextField().getText();
    }

    public String getText() {
        return this.tTextField.getTextField().getText();
    }

    public Map<String, String> getNoteValues() {
        Map<String, String> noteValues = new HashMap<>();

        noteValues.put("day", this.cTextField.getDatePicker().getValue().getDayOfMonth() + "");
        noteValues.put("weekDay", this.cTextField.getDatePicker().getValue().getDayOfWeek().toString().charAt(0)
                + this.cTextField.getDatePicker().getValue().getDayOfWeek().toString().substring(1).toLowerCase(Locale.ROOT));
        noteValues.put("year", this.cTextField.getDatePicker().getValue().getYear() + "");
        noteValues.put("month", this.cTextField.getDatePicker().getValue().getMonth().toString());
        noteValues.put("title", this.tTextField.getTextField().getText());
        noteValues.put("text", this.nTextArea.getTextArea().getText());
        //  Month month = Month.findByName(super.getCTextField().getDatePicker().getValue().getMonth().toString());

        return noteValues;
    }
}

package summercampfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import summercampfx.model.Course;
import summercampfx.utils.FileUtils;
import summercampfx.utils.MessageUtils;
import summercampfx.utils.Month;

import java.io.IOException;

public class NewCourseViewController {

    @FXML
    private TextField fieldName;

    @FXML
    private ComboBox<Month> comboBoxMonths;

    @FXML
    private ComboBox<Integer> comboBoxWeeks;

    private boolean saveData;

    public void handleSave(ActionEvent actionEvent) {
        String name = fieldName.getText();
        Month month = comboBoxMonths.getValue();
        Integer weeks = comboBoxWeeks.getValue();

        if (name.isEmpty()) {
            MessageUtils.showError("Empty field", "The name field is empty");
            return;
        } else if (month == null) {
            MessageUtils.showError("Empty selection", "The month field is empty");
            return;
        } else if (weeks == null) {
            MessageUtils.showError("Empty selection", "The duration field is empty");
            return;
        }
        Course course = new Course(name, month.getValue(), weeks);
        try {
            FileUtils.saveCourse(course.getLine());
            MessageUtils.showMessage("Course Save", "The course has been saved successfully");
            saveData = true;
            ((Stage)((Node)(actionEvent.getSource())).getScene().getWindow()).close();
        } catch (IOException e) {
            MessageUtils.showError("Save failed", e.getMessage());
        }
        saveData = true;
        ((Stage)((Node)(actionEvent.getSource())).getScene().getWindow()).close();
    }

    private void setComboWeeks(int startWeek, int endWeek) {
        ObservableList<Integer> weeks = FXCollections.observableArrayList();
        weeks.add(0, null);
        for (int i = startWeek; i <= endWeek; i++) {
            weeks.add(i);
        }
        comboBoxWeeks.setItems(weeks);
    }

    public boolean isSaveData() {
        return this.saveData;
    }

    @FXML
    public void initialize() {
        comboBoxMonths.setItems(FXCollections.observableArrayList(Month.values()));
        setComboWeeks(1, 10);
    }

}

package summercampfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import summercampfx.utils.MessageUtils;
import summercampfx.utils.Month;

public class NewCourseViewController {

    @FXML
    private TextField fieldName;

    @FXML
    private ComboBox<Month> comboBoxMonths;

    @FXML
    private ComboBox<Integer> comboBoxWeeks;

    public void handleSave() {
        if (fieldName.getText().isEmpty()) {
            MessageUtils.showError("Empty field", "The name field is empty");
            return;
        } else if (comboBoxMonths.getSelectionModel().isEmpty()) {
            MessageUtils.showError("Empty selection", "The month field is empty");
            return;
        } else if (comboBoxWeeks.getSelectionModel().getSelectedItem() == null) {
            MessageUtils.showError("Empty selection", "The duration field is empty");
            return;
        }
        System.out.println("OK");
    }

    private void setComboWeeks(int startWeek, int endWeek) {
        ObservableList<Integer> weeks = FXCollections.observableArrayList();
        weeks.add(0, null);
        for (int i = startWeek; i <= endWeek; i++) {
            weeks.add(i);
        }
        comboBoxWeeks.setItems(weeks);
    }

    @FXML
    public void initialize() {
        comboBoxMonths.setItems(FXCollections.observableArrayList(Month.values()));
        setComboWeeks(1, 10);
    }

}

package summercampfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import summercampfx.model.PendingApp;
import summercampfx.utils.FileUtils;
import summercampfx.utils.MessageUtils;
import summercampfx.utils.Month;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewApplicationViewController {

    @FXML
    private TextField fieldName;

    @FXML
    private DatePicker datePickerBirthday;

    @FXML
    private ComboBox<Month> comboBoxMonths;

    @FXML
    private TextField fieldSurnames;

    @FXML
    private ComboBox<Integer> comboBoxWeeks;

    @FXML
    private TextField fieldCourse;

    public void handleSave() {
        String name = fieldName.getText();
        String surnames = fieldSurnames.getText();
        LocalDate birthDate = datePickerBirthday.getValue();
        String course = fieldCourse.getText();
        Month month = comboBoxMonths.getValue();
        Integer weekDuration = comboBoxWeeks.getValue();

        if (fieldName.getText().isEmpty()) {
            MessageUtils.showError("Empty field", "The name field is empty");
            return;
        } else if (fieldSurnames.getText().isEmpty()) {
            MessageUtils.showError("Empty field", "The surnames field is empty");
            return;
        } else if (datePickerBirthday.getEditor().getText().isEmpty()) {
            MessageUtils.showError("Empty field", "The birthday field is empty");
            return;
        } else if (fieldCourse.getText().isEmpty()) {
            MessageUtils.showError("Empty field", "The course field is empty");
            return;
        } else if (comboBoxMonths.getSelectionModel().isEmpty()) {
            MessageUtils.showError("Empty selection", "The month field is empty");
            return;
        } else if (comboBoxWeeks.getSelectionModel().getSelectedItem() == null) {
            MessageUtils.showError("Empty selection", "The duration field is empty");
            return;
        }
        PendingApp pendingApp = new PendingApp(name, surnames, birthDate, course, month, weekDuration);
        FileUtils.saveApp(pendingApp.getLine());
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

    private void setDatePickerBirthdayFormat() {
        datePickerBirthday.setConverter(new StringConverter<>() {
            private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null) {
                    return "";
                }
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
    }

    @FXML
    public void initialize() {
        comboBoxMonths.setItems(FXCollections.observableArrayList(Month.values()));
        setComboWeeks(1, 12);
        setDatePickerBirthdayFormat();
    }

}

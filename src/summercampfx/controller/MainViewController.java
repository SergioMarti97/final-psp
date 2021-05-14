package summercampfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import summercampfx.model.Course;
import summercampfx.model.PendingApp;
import summercampfx.utils.FileUtils;
import summercampfx.utils.MessageUtils;

import java.io.IOException;
import java.util.List;

public class MainViewController {

    @FXML
    public TableView<PendingApp> studentsTableView;

    @FXML
    public TableColumn<PendingApp, String> nameCol;

    @FXML
    public TableColumn<PendingApp, String> surnamesCol;

    @FXML
    public TableColumn<PendingApp, String> birthDateCol;

    @FXML
    public TableView<PendingApp> cabinTableView;

    @FXML
    public TableColumn<PendingApp, String> nameCol2;

    @FXML
    public TableColumn<PendingApp, String> surnamesCol2;

    @FXML
    public ComboBox<Course> comboCourses;

    @FXML
    public ComboBox<Integer> comboAge;

    @FXML
    private ListView<String> listCabins;

    @FXML
    private TextField cabinTextField;

    private Stage mainStage;

    private void setCourses() {
        ObservableList<Course> courses = FXCollections.observableArrayList();
        courses.add(0, null);
        courses.addAll(FileUtils.loadCourses());
        comboCourses.setItems(courses);
    }

    private void setComboAge(int startAge, int endAge) {
        ObservableList<Integer> ages = FXCollections.observableArrayList();
        ages.add(0, null);
        for (int i = startAge; i <= endAge; i++) {
            ages.add(i);
        }
        comboAge.setItems(ages);
    }

    private void setColumnsFirstTable() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnamesCol.setCellValueFactory(new PropertyValueFactory<>("surnames"));
        birthDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
    }

    private void setColumnsSecondTable() {
        nameCol2.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnamesCol2.setCellValueFactory(new PropertyValueFactory<>("surnames"));
    }

    public void handleFillCabin() {
        PendingApp pendingApp = studentsTableView.getSelectionModel().getSelectedItem();
        Course course = comboCourses.getValue();
        Integer age = comboAge.getValue();

        if (pendingApp == null) {
            MessageUtils.showError("Student selection", "You must select a student");
            return;
        } else if (course == null) {
            MessageUtils.showError("Course selection", "You must select a course");
            return;
        } else if (age == null) {
            MessageUtils.showError("Age selection", "You must select an age");
            return;
        }

        studentsTableView.getItems().remove(pendingApp);
        cabinTableView.getItems().add(pendingApp);
    }

    public void handleSaveCabin() {
        String cabin = cabinTextField.getText();
        List<PendingApp> students = cabinTableView.getItems();

        if (cabin == null || cabin.isEmpty()) {
            MessageUtils.showError("Cabin field", "The cabin field is empty");
            return;
        } else if (students == null || students.isEmpty()) {
            MessageUtils.showError("Students selections", "The students selection is empty");
            return;
        }

        try {
            FileUtils.saveCabin(cabin, students, 10);
            listCabins.getItems().clear();
            listCabins.getItems().addAll(FileUtils.loadCabinsFileNames());

            if (students.size() > 10) {
                MessageUtils.showMessage("Cabin Save", "The cabin has been saved successfully the first 10 students");
                return;
            }

            MessageUtils.showMessage("Cabin Save", "The cabin has been saved successfully");
        } catch (IOException e) {
            MessageUtils.showError("Save error", e.getMessage());
        }
    }

    public void handleNewCourse() throws Exception {
        boolean saveData = openWindow("New course", "views/NewCourseView.fxml");
        if (saveData) {
            comboCourses.getItems().clear();
            setCourses();
        }
    }

    public void handleNewApplication() throws Exception {
        boolean saveData = openWindow("New Application", "views/NewApplicationView.fxml");
        if (saveData) {
            studentsTableView.getItems().clear();
            studentsTableView.setItems(FXCollections.observableArrayList(FileUtils.loadApps()));
        }
    }

    private boolean openWindow(String title, String location) throws Exception {
        Stage stage = new Stage();
        stage.setTitle(title);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../" + location));
        Parent root = loader.load();

        if (title.equals("New Application")) {
            NewApplicationViewController controller = loader.getController();
            showWindowStage(stage, root);
            return controller.isSaveData();
        }

        NewCourseViewController controller = loader.getController();
        showWindowStage(stage, root);
        return controller.isSaveData();
    }

    private void showWindowStage(Stage stage, Parent root) {
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(mainStage);
        stage.showAndWait();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    public void initialize() {
        // studentsTableView;
        setColumnsFirstTable();
        setColumnsSecondTable();
        setComboAge(6, 16);
        setCourses();
        studentsTableView.setItems(FXCollections.observableArrayList(FileUtils.loadApps()));
        listCabins.getItems().addAll(FileUtils.loadCabinsFileNames());
    }

}

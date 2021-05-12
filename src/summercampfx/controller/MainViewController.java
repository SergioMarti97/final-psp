package summercampfx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import summercampfx.model.Course;
import summercampfx.model.PendingApp;
import summercampfx.utils.FileUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    public TableView<PendingApp> studentsTableView;

    @FXML
    public TableColumn<PendingApp, String> nameCol;

    @FXML
    public TableColumn<PendingApp, String> surnamesCol;

    @FXML
    public TableColumn<PendingApp, String> birthDateCol;

    @FXML
    public TableColumn<PendingApp, String> nameCol2;

    @FXML
    public TableColumn<PendingApp, String> surnamesCol2;

    @FXML
    public ComboBox<Course> comboCourses;

    @FXML
    public ComboBox<Integer> comboAge;

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
        nameCol2.setCellValueFactory(new PropertyValueFactory<>("surnames"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // studentsTableView;
        setColumnsFirstTable();
        setColumnsSecondTable();
        setComboAge(6, 16);
        setCourses();
        studentsTableView.setItems(FXCollections.observableArrayList(FileUtils.loadApps()));
    }

    public void handleNewCourse() throws Exception {
        openWindow("New course", "views/NewCourseView.fxml");
    }

    public void handleNewApplication() throws Exception {
        openWindow("New Application", "views/NewApplicationView.fxml");
    }

    private void openWindow(String title, String location) throws Exception {
        Stage stage = new Stage();
        stage.setTitle(title);
        Parent root = FXMLLoader.load(getClass().getResource("../" + location));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(mainStage);
        stage.show();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}

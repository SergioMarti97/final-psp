package summercampfx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import summercampfx.model.PendingApp;
import summercampfx.utils.FileUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLMainViewController implements Initializable {

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
        studentsTableView.setItems(FXCollections.observableArrayList(FileUtils.loadApps()));
    }

}

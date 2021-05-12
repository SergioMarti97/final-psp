package summercampfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import summercampfx.controller.MainViewController;

/**
 * This class is the summer camp
 *
 * @class SummerCampFX
 * @author Sergio Martí Torregrosa
 * @date 26/10/2020
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/MainView.fxml"));
        Parent root = loader.load();
        MainViewController controller = loader.getController();
        stage.setTitle("Summer camp FX");
        stage.setScene(new Scene(root, 650, 400));
        stage.setResizable(false);
        controller.setMainStage(stage);
        stage.show();
    }

    /**
     * The main method, the executable point of the program
     * @param args the arguments of the application
     */
    public static void main(String[] args) {
        launch(args);
    }

}

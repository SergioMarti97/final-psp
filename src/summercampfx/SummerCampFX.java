package summercampfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is the summer camp
 *
 * @class SummerCampFX
 * @author Sergio Martí Torregrosa
 * @date 26/10/2020
 */
public class SummerCampFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainView.fxml"));
        stage.setTitle("Summer camp FX");
        stage.setScene(new Scene(root));
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

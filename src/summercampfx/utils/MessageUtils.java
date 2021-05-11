package summercampfx.utils;

import javafx.scene.control.Alert;

/**
 * This class is needed for show the different
 * Alert messages
 *
 * @class MessageUtils
 * @author Sergio Martí Torregrosa
 * @date 26/10/2020
 */
public class MessageUtils {

    /**
     * This method shows an error message
     * @param header the header for the error
     * @param message the text of the message
     */
    public static void showError(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * This method shows a message
     * @param header the header for the message
     * @param message the text of the message
     */
    public static void showMessage(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

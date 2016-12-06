package pl.moja.biblioteczka.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by ZacznijProgramowac on 05.12.2016.
 */
public class DialogsUtils {

    private static final ResourceBundle bundle = FxmlUtils.getResourceBundle();

    public static void dialogAboutApplication(){
        Alert informationAlert =  new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("about.title"));
        informationAlert.setHeaderText(bundle.getString("about.header"));
        informationAlert.setContentText(bundle.getString("about.content"));
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> confirmationDialog(){
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(bundle.getString("exit.title"));
        confirmationDialog.setHeaderText(bundle.getString("exit.header"));
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;
    }

    public static void errorDialog(String error){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("exit.title"));
        errorAlert.setHeaderText(bundle.getString("exit.header"));

        TextArea textArea = new TextArea(error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();

    }


}

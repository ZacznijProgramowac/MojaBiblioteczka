package pl.moja.biblioteczka;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.moja.biblioteczka.database.dbuitls.DbManager;
import pl.moja.biblioteczka.utils.FillDatabase;
import pl.moja.biblioteczka.utils.FxmlUtils;

/**
 * Created by ZacznijProgramowac on 09.11.2016.
 */
public class Main extends Application {

    private static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("tittle.application"));
        primaryStage.show();

        DbManager.initDatabase();
        FillDatabase.fillDatabase();
    }
}

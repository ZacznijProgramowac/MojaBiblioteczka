package pl.moja.biblioteczka.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

/**
 * Created by ZacznijProgramowac on 09.11.2016.
 */
public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    @FXML
    private void initialize() {
        topMenuButtonsController.setMainController(this);
    }

}

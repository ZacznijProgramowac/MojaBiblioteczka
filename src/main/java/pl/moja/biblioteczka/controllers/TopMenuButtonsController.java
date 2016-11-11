package pl.moja.biblioteczka.controllers;

import javafx.fxml.FXML;

/**
 * Created by ZacznijProgramowac on 11.11.2016.
 */
public class TopMenuButtonsController {

    private MainController mainController;

    @FXML
    public void openLibrary() {
        System.out.println("openLibrary");
    }

    @FXML
    public void openListBooks() {
        System.out.println("openListBooks");
    }

    @FXML
    public void openStatistics() {
        System.out.println("openStatistics");
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}

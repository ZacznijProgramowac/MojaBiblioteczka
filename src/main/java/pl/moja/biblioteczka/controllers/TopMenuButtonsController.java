package pl.moja.biblioteczka.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class TopMenuButtonsController {

    private static final String LIBRARY_FXML = "/fxml/Library.fxml";
    private static final String LIST_BOOKS_FXML = "/fxml/ListBooks.fxml";
    private static final String STATISTICS_FXML = "/fxml/Statistics.fxml";
    private static final String ADD_BOOK_FXML = "/fxml/AddBook.fxml";
    private static final String ADD_CATEGORY_FXML = "/fxml/AddCategory.fxml";
    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openLibrary() {
        mainController.setCenter(LIBRARY_FXML);
    }

    @FXML
    public void openListBooks() {
        mainController.setCenter(LIST_BOOKS_FXML);
    }

    @FXML
    public void openStatistics() {
        mainController.setCenter(STATISTICS_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void addBook() {
        resetToggleButtons();
        mainController.setCenter(ADD_BOOK_FXML);
    }

    public void addCategory(ActionEvent actionEvent) {
        resetToggleButtons();
        mainController.setCenter(ADD_CATEGORY_FXML);
    }

    private void resetToggleButtons() {
        if(toggleButtons.getSelectedToggle()!=null){
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }
}

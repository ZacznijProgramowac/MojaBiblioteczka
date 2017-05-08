package pl.moja.biblioteczka.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.moja.biblioteczka.modelFx.AuthorFx;
import pl.moja.biblioteczka.modelFx.BookFx;
import pl.moja.biblioteczka.modelFx.CategoryFx;
import pl.moja.biblioteczka.modelFx.ListBooksModel;
import pl.moja.biblioteczka.utils.DialogsUtils;
import pl.moja.biblioteczka.utils.exceptions.ApplicationException;

import java.time.LocalDate;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class ListBooksController {

    @FXML
    private TableView<BookFx> booksTableView;
    @FXML
    private TableColumn<BookFx, String> titleColumn;
    @FXML
    private TableColumn<BookFx, String> descColumn;
    @FXML
    private TableColumn<BookFx, AuthorFx> authorColumn;
    @FXML
    private TableColumn<BookFx, CategoryFx> categoryColumn;
    @FXML
    private TableColumn<BookFx, Number> ratingColumn;
    @FXML
    private TableColumn<BookFx, String> isbnColumn;
    @FXML
    private TableColumn<BookFx, LocalDate> releaseColumn;

    private ListBooksModel listBooksModel;

    @FXML
    void initialize(){
       this.listBooksModel = new ListBooksModel();
        try {
            this.listBooksModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }

        this.booksTableView.setItems(this.listBooksModel.getBookFxObservableList());
        this.titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        this.descColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        this.ratingColumn.setCellValueFactory(cellData -> cellData.getValue().ratingProperty());
        this.isbnColumn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
        this.releaseColumn.setCellValueFactory(cellData -> cellData.getValue().releaseDateProperty());
        this.authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorFxProperty());
        this.categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryFxProperty());
    }
}

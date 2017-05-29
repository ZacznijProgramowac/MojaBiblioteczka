package pl.moja.biblioteczka.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import pl.moja.biblioteczka.modelFx.AuthorFx;
import pl.moja.biblioteczka.modelFx.BookModel;
import pl.moja.biblioteczka.modelFx.CategoryFx;
import pl.moja.biblioteczka.utils.DialogsUtils;
import pl.moja.biblioteczka.utils.exceptions.ApplicationException;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class BookController {

    @FXML
    private Button addButton;
    @FXML
    private ComboBox<CategoryFx> categoryComboBox;
    @FXML
    private ComboBox<AuthorFx> authorComboBox;
    @FXML
    private TextArea descTextArea;
    @FXML
    private Slider ratingSlider;
    @FXML
    private TextField isbnTextField;
    @FXML
    private DatePicker releaseDatePicker;
    @FXML
    private TextField titleTextField;

    private BookModel bookModel;

    @FXML
    public void initialize() {
        this.bookModel = new BookModel();
        try {
            this.bookModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        bindings();
        validation();
    }

    private void validation() {
        this.addButton.disableProperty().bind(this.authorComboBox.valueProperty().isNull()
                .or(this.categoryComboBox.valueProperty().isNull())
                .or(this.titleTextField.textProperty().isEmpty())
                .or(this.descTextArea.textProperty().isEmpty())
                .or(this.isbnTextField.textProperty().isEmpty())
                .or(this.releaseDatePicker.valueProperty().isNull()));
    }

    public void bindings() {
        this.categoryComboBox.setItems(this.bookModel.getCategoryFxObservableList());
        this.authorComboBox.setItems(this.bookModel.getAuthorFxObservableList());

        this.authorComboBox.valueProperty().bindBidirectional(this.bookModel.getBookFxObjectProperty().authorFxProperty());
        this.categoryComboBox.valueProperty().bindBidirectional(this.bookModel.getBookFxObjectProperty().categoryFxProperty());
        this.titleTextField.textProperty().bindBidirectional(this.bookModel.getBookFxObjectProperty().titleProperty());
        this.descTextArea.textProperty().bindBidirectional(this.bookModel.getBookFxObjectProperty().descriptionProperty());
        this.ratingSlider.valueProperty().bindBidirectional(this.bookModel.getBookFxObjectProperty().ratingProperty());
        this.isbnTextField.textProperty().bindBidirectional(this.bookModel.getBookFxObjectProperty().isbnProperty());
        this.releaseDatePicker.valueProperty().bindBidirectional(this.bookModel.getBookFxObjectProperty().releaseDateProperty());
    }

    public void addBookOnAction() {
        try {
            this.bookModel.saveBookInDataBase();
            clearFields();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    private void clearFields() {
        this.authorComboBox.getSelectionModel().clearSelection();
        this.categoryComboBox.getSelectionModel().clearSelection();
        this.titleTextField.clear();
        this.descTextArea.clear();
        this.ratingSlider.setValue(1);
        this.isbnTextField.clear();
        this.releaseDatePicker.getEditor().clear();
    }

    public BookModel getBookModel() {
        return bookModel;
    }
}

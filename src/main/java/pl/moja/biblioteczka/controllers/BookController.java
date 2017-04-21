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
    public void initialize(){
        this.bookModel = new BookModel();
        try {
            this.bookModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        bindings();
    }

    private void bindings() {
        this.categoryComboBox.setItems(this.bookModel.getCategoryFxObservableList());
        this.authorComboBox.setItems(this.bookModel.getAuthorFxObservableList());
        this.bookModel.getBookFxObjectProperty().categoryFxProperty().bind(this.categoryComboBox.valueProperty());
        this.bookModel.getBookFxObjectProperty().authorFxProperty().bind(this.authorComboBox.valueProperty());
        this.bookModel.getBookFxObjectProperty().titleProperty().bind(this.titleTextField.textProperty());
        this.bookModel.getBookFxObjectProperty().descriptionProperty().bind(this.descTextArea.textProperty());
        this.bookModel.getBookFxObjectProperty().ratingProperty().bind(ratingSlider.valueProperty());
        this.bookModel.getBookFxObjectProperty().isbnProperty().bind(this.isbnTextField.textProperty());
        this.bookModel.getBookFxObjectProperty().releaseDateProperty().bind(this.releaseDatePicker.valueProperty());
    }

    public void addBookOnAction() {
        System.out.println(this.bookModel.getBookFxObjectProperty().toString());
    }


}

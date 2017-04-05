package pl.moja.biblioteczka.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import pl.moja.biblioteczka.modelFx.AuthorFx;
import pl.moja.biblioteczka.modelFx.AuthorModel;
import pl.moja.biblioteczka.utils.DialogsUtils;
import pl.moja.biblioteczka.utils.exceptions.ApplicationException;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class AuthorController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Button addButton;
    @FXML
    private TableView<AuthorFx> authorTableView;
    @FXML
    private TableColumn<AuthorFx, String> nameColumn;
    @FXML
    private TableColumn<AuthorFx, String> surnameColumn;


    private AuthorModel authorModel;

    public void initialize() {
        this.authorModel = new AuthorModel();
        try {
            this.authorModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.authorModel.authorFxObjectPropertyProperty().get().nameProperty().bind(this.nameTextField.textProperty());
        this.authorModel.authorFxObjectPropertyProperty().get().surnameProperty().bind(this.surnameTextField.textProperty());
        this.addButton.disableProperty().bind(this.nameTextField.textProperty().isEmpty().or(this.surnameTextField.textProperty().isEmpty()));

        this.authorTableView.setItems(this.authorModel.getAuthorFxObservableList());
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.surnameColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());

        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.surnameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        this.authorTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.authorModel.setAuthorFxObjectPropertyEdit(newValue);
        });

    }

    public void addAuthorOnAction() {
        try {
            this.authorModel.saveAuthorInDataBase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.nameTextField.clear();
        this.surnameTextField.clear();
    }

    public void onEditCommitName(TableColumn.CellEditEvent<AuthorFx, String> authorFxStringCellEditEvent) {
        this.authorModel.getAuthorFxObjectPropertyEdit().setName(authorFxStringCellEditEvent.getNewValue());
        updateInDatabase();
    }

    public void onEditCommitSurname(TableColumn.CellEditEvent<AuthorFx, String> authorFxStringCellEditEvent) {
        this.authorModel.getAuthorFxObjectPropertyEdit().setSurname(authorFxStringCellEditEvent.getNewValue());
        updateInDatabase();
    }

    private void updateInDatabase() {
        try {
            this.authorModel.saveAuthorEditInDataBase();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }
}

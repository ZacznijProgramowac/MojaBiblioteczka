package pl.moja.biblioteczka.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.moja.biblioteczka.database.dao.AuthorDao;
import pl.moja.biblioteczka.database.dbuitls.DbManager;
import pl.moja.biblioteczka.database.models.Author;
import pl.moja.biblioteczka.utils.converters.ConverterAuthor;
import pl.moja.biblioteczka.utils.exceptions.ApplicationException;

import java.util.List;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class AuthorModel {

    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>(new AuthorFx());
    private ObjectProperty<AuthorFx> authorFxObjectPropertyEdit = new SimpleObjectProperty<>(new AuthorFx());

    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();


    public void init() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        List<Author> authorList = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authorList.forEach(author -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(author);
            this.authorFxObservableList.add(authorFx);
        });
        DbManager.closeConnectionSource();
    }

    public void saveAuthorEditInDataBase() throws ApplicationException {
        saveOrUpdate(this.getAuthorFxObjectPropertyEdit());
    }
    public void saveAuthorInDataBase() throws ApplicationException {
        saveOrUpdate(this.getAuthorFxObjectProperty());
    }

    private void saveOrUpdate(AuthorFx authorFxObjectPropertyEdit) throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        Author author = ConverterAuthor.converToAuthor(authorFxObjectPropertyEdit);
        authorDao.creatOrUpdate(author);
        DbManager.closeConnectionSource();
        this.init();
    }





    public AuthorFx getAuthorFxObjectProperty() {
        return authorFxObjectProperty.get();
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyProperty() {
        return authorFxObjectProperty;
    }

    public void setAuthorFxObjectProperty(AuthorFx authorFxObjectProperty) {
        this.authorFxObjectProperty.set(authorFxObjectProperty);
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
    }

    public AuthorFx getAuthorFxObjectPropertyEdit() {
        return authorFxObjectPropertyEdit.get();
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyEditProperty() {
        return authorFxObjectPropertyEdit;
    }

    public void setAuthorFxObjectPropertyEdit(AuthorFx authorFxObjectPropertyEdit) {
        this.authorFxObjectPropertyEdit.set(authorFxObjectPropertyEdit);
    }
}

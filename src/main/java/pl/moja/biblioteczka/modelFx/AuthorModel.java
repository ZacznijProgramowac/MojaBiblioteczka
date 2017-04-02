package pl.moja.biblioteczka.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import pl.moja.biblioteczka.database.dao.AuthorDao;
import pl.moja.biblioteczka.database.dbuitls.DbManager;
import pl.moja.biblioteczka.database.models.Author;
import pl.moja.biblioteczka.utils.converters.ConverterAuthor;
import pl.moja.biblioteczka.utils.exceptions.ApplicationException;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class AuthorModel {

    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>(new AuthorFx());


    public void saveAuthorInDataBase() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao(DbManager.getConnectionSource());
        Author author = ConverterAuthor.convertAuthorFxToAuthor(this.getAuthorFxObjectProperty());
        authorDao.creatOrUpdate(author);
        DbManager.closeConnectionSource();
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
}

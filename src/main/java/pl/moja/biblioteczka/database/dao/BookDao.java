package pl.moja.biblioteczka.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import pl.moja.biblioteczka.database.models.Book;
import pl.moja.biblioteczka.utils.exceptions.ApplicationException;

import java.sql.SQLException;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class BookDao extends CommonDao {

    public BookDao() {
        super();
    }

    public void deleteByColumnName(String columName, int id) throws ApplicationException, SQLException {
        Dao<Book, Object> dao = getDao(Book.class);
        DeleteBuilder<Book, Object> deleteBuilder = dao.deleteBuilder();
        deleteBuilder.where().eq(columName, id);
        dao.delete(deleteBuilder.prepare());
    }

}

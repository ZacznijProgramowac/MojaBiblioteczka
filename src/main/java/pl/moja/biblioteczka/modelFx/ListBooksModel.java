package pl.moja.biblioteczka.modelFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.moja.biblioteczka.database.dao.BookDao;
import pl.moja.biblioteczka.database.models.Book;
import pl.moja.biblioteczka.utils.converters.ConverterBook;
import pl.moja.biblioteczka.utils.exceptions.ApplicationException;

import java.util.List;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class ListBooksModel {

    private ObservableList<BookFx> bookFxObservableList = FXCollections.observableArrayList();

    public void init() throws ApplicationException {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.queryForAll(Book.class);
        books.forEach(book -> {
            this.bookFxObservableList.add(ConverterBook.convertToBookFx(book));
        });
    }

    public ObservableList<BookFx> getBookFxObservableList() {
        return bookFxObservableList;
    }

    public void setBookFxObservableList(ObservableList<BookFx> bookFxObservableList) {
        this.bookFxObservableList = bookFxObservableList;
    }
}

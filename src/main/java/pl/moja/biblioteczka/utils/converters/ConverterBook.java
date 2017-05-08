package pl.moja.biblioteczka.utils.converters;

import pl.moja.biblioteczka.database.models.Book;
import pl.moja.biblioteczka.modelFx.BookFx;
import pl.moja.biblioteczka.utils.Utils;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class ConverterBook {

    public static Book convertToBook(BookFx bookFx){
        Book book = new Book();
        book.setId(bookFx.getId());
        book.setTitle(bookFx.getTitle());
        book.setDescription(bookFx.getDescription());
        book.setRating(bookFx.getRating());
        book.setIsbn(bookFx.getIsbn());
        book.setReleaseDate(Utils.convertToDate(bookFx.getReleaseDate()));
        book.setAddedDate(Utils.convertToDate(bookFx.getAddedDate()));
        return  book;
    }

    public static BookFx convertToBookFx(Book book){
        BookFx bookFx = new BookFx();
        bookFx.setId(book.getId());
        bookFx.setTitle(book.getTitle());
        bookFx.setDescription(book.getDescription());
        bookFx.setRating(book.getRating());
        bookFx.setIsbn(book.getIsbn());
        bookFx.setReleaseDate(Utils.convertToLocalDate(book.getReleaseDate()));
        bookFx.setAuthorFx(ConverterAuthor.convertToAuthorFx(book.getAuthor()));
        bookFx.setCategoryFx(ConverterCategory.convertToCategoryFx(book.getCategory()));
        return bookFx;
    }

}

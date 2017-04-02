package pl.moja.biblioteczka.utils.converters;

import pl.moja.biblioteczka.database.models.Author;
import pl.moja.biblioteczka.modelFx.AuthorFx;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class ConverterAuthor {


    public static Author convertAuthorFxToAuthor(AuthorFx authorFx){
        Author author = new Author();
        author.setName(authorFx.getName());
        author.setSurname(authorFx.getSurname());
        return author;
    }
}

package pl.moja.biblioteczka.utils.converters;

import pl.moja.biblioteczka.database.models.Author;
import pl.moja.biblioteczka.modelFx.AuthorFx;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
public class ConverterAuthor {


    public static Author converToAuthor(AuthorFx authorFx){
        Author author = new Author();
        author.setId(authorFx.getId());
        author.setName(authorFx.getName());
        author.setSurname(authorFx.getSurname());
        return author;
    }

    public static AuthorFx convertToAuthorFx(Author author){
        AuthorFx authorFx = new AuthorFx();
        authorFx.setId(author.getId());
        authorFx.setName(author.getName());
        authorFx.setSurname(author.getSurname());
        return authorFx;
    }
}

package pl.moja.biblioteczka.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ZacznijProgramowac.
 * https://www.youtube.com/zacznijprogramowac
 * http://zacznijprogramowac.net/
 */
@DatabaseTable(tableName = "AUTHORS")
public class Author implements BaseModel{
    public Author() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String name;

    @DatabaseField(columnName = "SURNAME", canBeNull = false)
    private String surname;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ForeignCollection<Book> getBooks() {
        return books;
    }

    public void setBooks(ForeignCollection<Book> books) {
        this.books = books;
    }
}

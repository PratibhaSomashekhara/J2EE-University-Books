package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Author;
import model.BookType;
import model.Librarian;
import model.Students;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T01:22:25")
@StaticMetamodel(Book.class)
public class Book_ extends BaseEntity_ {

    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, Students> students;
    public static volatile SingularAttribute<Book, Librarian> librarian;
    public static volatile SingularAttribute<Book, Integer> nbOfPage;
    public static volatile SingularAttribute<Book, BookType> type;
    public static volatile SingularAttribute<Book, Date> publicationDate;
    public static volatile SetAttribute<Book, Author> authors;

}
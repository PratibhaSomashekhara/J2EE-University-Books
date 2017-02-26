package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Book;
import model.Students;
import model.security.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T01:22:25")
@StaticMetamodel(Librarian.class)
public class Librarian_ extends Person_ {

    public static volatile SingularAttribute<Librarian, String> address;
    public static volatile ListAttribute<Librarian, Book> books;
    public static volatile SingularAttribute<Librarian, String> city;
    public static volatile ListAttribute<Librarian, Students> students;
    public static volatile SingularAttribute<Librarian, String> telephone;
    public static volatile SingularAttribute<Librarian, User> user;

}
package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Book;
import model.Librarian;
import model.security.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T01:22:25")
@StaticMetamodel(Students.class)
public class Students_ extends Person_ {

    public static volatile ListAttribute<Students, Book> books;
    public static volatile SingularAttribute<Students, Librarian> librarian;
    public static volatile SingularAttribute<Students, User> user;

}
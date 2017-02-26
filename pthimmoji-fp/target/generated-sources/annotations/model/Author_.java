package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Book;
import model.EmailId;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T01:22:25")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile SingularAttribute<Author, String> firstname;
    public static volatile SingularAttribute<Author, Book> book;
    public static volatile SingularAttribute<Author, EmailId> emailId;
    public static volatile SingularAttribute<Author, Long> id;
    public static volatile SingularAttribute<Author, String> lastname;

}
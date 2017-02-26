/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
import java.util.Date;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This is the book details
 * @author Lenovo
 */
@Entity
@Table(name = "Book")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "select a from Book a")
    ,
    @NamedQuery(name = "findWithParam", query = "select b from Book b where b.title = :title")
    ,
    @NamedQuery(name = "FindC#", query = "select b from Book b where b.title = 'C#'"),})
public class Book extends BaseEntity {

    private String isbn;
    private Integer nbOfPage;
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students students;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BookType type;

    public Book() {
    }

    public Book(String isbn, Integer nbOfPage, Date publicationDate) {
        this.isbn = isbn;
        this.nbOfPage = nbOfPage;
        this.publicationDate = publicationDate;
    }

    public Book(String isbn, Integer nbOfPage, Date publicationDate, String title, String description, Integer version) {
        super(title, description, version);
        this.isbn = isbn;
        this.nbOfPage = nbOfPage;
        this.publicationDate = publicationDate;
    }

    public Book(Integer nbOfPage, Date publicationDate, Librarian librarian, BookType type, String title, String description, Integer version) {
        super(title, description, version);
        this.nbOfPage = nbOfPage;
        this.publicationDate = publicationDate;
        this.librarian = librarian;
        this.type = type;
    }

    public Book(Integer nbOfPage, Date publicationDate, String title, String description, Integer version) {
        super(title, description, version);
        this.nbOfPage = nbOfPage;
        this.publicationDate = publicationDate;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNbOfPage() {
        return nbOfPage;
    }

    public void setNbOfPage(Integer nbOfPage) {
        this.nbOfPage = nbOfPage;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthor(Set<Author> authors) {
        this.authors = authors;
    }

    public void setAuthor(Author authors) {
        this.authors.add(authors);
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void addAuthor(Author author) {
        if (authors == null) {
            authors = new HashSet<>();
        }
        if (!this.authors.contains(author)) {
            this.authors.add(author);
        }
        if (author.getBook() != this) {
            author.setBook(this);
        }
        authors.add(author);

    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ",\t nbOfPage=" + nbOfPage + ",\t publicationDate=" + publicationDate + ", \t title=" + super.getTitle() + ",\t description=" + super.getDescription() + ",\t version=" + super.getDescription() + ",\t authors=" + authors + '}';
    }

}

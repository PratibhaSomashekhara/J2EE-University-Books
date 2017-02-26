/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import model.security.User;

/**
 * Student Details
 * @author Lenovo
 */
@Entity
@Table(name = "students")
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "select o from Students o")
    ,
    @NamedQuery(name = "Students.findByUsername", query = "select o from Students o where o.user.userName = :userName")
})

public class Students extends Person {

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "students")
    @OneToMany(mappedBy = "students", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Book> books;

    @ManyToOne
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;

    public Students(User user) {
        this.user = user;
    }

    public Students() {
        this.user = new User();
    }

    public Students(String firstName, String lastName) {
        super(firstName, lastName);
    }

    protected List<Book> getBooksInternal() {
        if (this.books == null) {
            this.books = new ArrayList<>();
        }
        return this.books;
    }

    protected void setBooksInternal(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        List<Book> sortedBooks = new ArrayList<>(getBooksInternal());
//        PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedBooks);
    }

    public void addBook(Book book) {
        getBooksInternal().add(book);
        book.setStudents(this);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Book getBook(String name) {
        return getBook(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Book getBook(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Book book : getBooksInternal()) {
            if (!ignoreNew || !book.isNew()) {
                String compName = book.getTitle();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return book;
                }
            }
        }
        return null;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Students(User user, Librarian librarian, String firstName, String lastName) {
        super(firstName, lastName);
        this.user = user;
        this.librarian = librarian;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Students(User user, List<Book> books, Librarian librarian, String firstName, String lastName) {
        super(firstName, lastName);
        this.user = user;
        this.books = books;
        this.librarian = librarian;
    }

}

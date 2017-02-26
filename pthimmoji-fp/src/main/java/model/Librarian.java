/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import model.security.User;

/**
 * It contains Librarian Details
 * @author Lenovo
 */
@Entity
@Table(name = "librarian")
@NamedQueries({
    @NamedQuery(name = "Librarian.findAll", query = "select v from Librarian v")
    ,
    @NamedQuery(name = "Librarian.findByUsername", query = "select v from Librarian v where v.user.userName = :userName")
})
public class Librarian extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    @Digits(fraction = 0, integer = 10)
    private String telephone;
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    @OneToMany(mappedBy = "librarian", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)

    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "librarian")
    private List<Book> books;
    @OneToMany(mappedBy = "librarian", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    //  @OneToMany(cascade = CascadeType.ALL, mappedBy = "librarian")
    private List<Students> students;

    public Librarian() {
    }

    public Librarian(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    protected List<Book> getPetsInternal() {
        if (this.books == null) {
//            this.pets = new HashSet<>();
            this.books = new ArrayList<>();
        }
        return this.books;
    }

    protected List<Students> getStudentsInternal() {
        if (this.students == null) {
//            this.pets = new HashSet<>();
            this.students = new ArrayList<>();
        }
        return this.students;
    }

    protected void setPetsInternal(List<Book> books) {
        this.books = books;
    }

    protected void setStudentsInternal(List<Students> students) {
        this.students = students;
    }

    public List<Book> getBooks() {
        List<Book> sortedPets = new ArrayList<>(getPetsInternal());
//        PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPets);
    }

    public List<Students> getStudents() {
        List<Students> sortedStudents = new ArrayList<>(getStudentsInternal());
//        PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedStudents);
    }

    public void addBook(Book book) {
        getPetsInternal().add(book);
        book.setLibrarian(this);
    }

    public void addStudent(Students students) {
        getStudentsInternal().add(students);
        students.setLibrarian(this);
    }

    public void removeBook(Book p) {
        getPetsInternal().remove(p);
        p.setLibrarian(null);
    }

    public void removeStudent(Students p) {
        getStudentsInternal().remove(p);
        p.setLibrarian(null);
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

    public Students getStudents(String name) {
        return getStudents(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this Owner.
     *
     * @param name to test
     * @return true if pet name is already in use
     */
    public Book getBook(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Book book : getPetsInternal()) {
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

    public Students getStudents(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Students students : getStudentsInternal()) {
            if (!ignoreNew || !students.isNew()) {
                String compName = students.getFirstName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return students;
                }
            }
        }
        return null;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

//    public List<Students> getStudents() {
//        return students;
//    }
    public void setStudents(List<Students> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Librarian{" + "address=" + address + ", city=" + city + ", telephone=" + telephone + '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

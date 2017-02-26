/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This entity contains Author details
 * @author Pratibha Thimmoji
 */
@Entity
@Table(name = "Author")
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "select a from Author a")
})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstname;
    private String lastname;

    @OneToOne
    @JoinColumn(name = "EMAIL_ID_FK")
    private EmailId emailId;

    @ManyToOne
    //DEFAULT TO JOIN COLUMN
    @JoinTable(name = "BOOK_AUTHOR",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Book book;

    public Author() {
    }

    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Author(String firstname, String lastname, EmailId emailId, Book book) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
        this.book = book;
    }

    public Author(String firstname, String lastname, EmailId emailId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailId = emailId;
    }

    public EmailId getEmailId() {
        return emailId;
    }

    public void setEmailId(EmailId emailId) {
        this.emailId = emailId;
    }

    public Book getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBook(Book book) {
        this.book = book;
        if (!book.getAuthors().contains(this)) {
            book.getAuthors().add(this);
        }
    }

    @Override
    public String toString() {
        return "Author{" + "firstname=" + firstname + ",\t lastname=" + lastname + " ,\t Book ID = " + book.getId() + " \t , Email ID =" + emailId + "}";
    }

}

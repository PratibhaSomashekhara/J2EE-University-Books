/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Book;
import model.BookType;
import model.Students;
import service.BookService;
import service.StudentsService;

/**
 * Student Controller
 * @author Lenova
 */
@Named
@RequestScoped
public class StudentsController extends BaseController {

    @Inject
    LoginController loginController;
    @EJB
    StudentsService studentsService;
    @EJB
    BookService bookService;

    private Students students;
    private Book book;

    List<Book> studentsBooks = new ArrayList<>();
    List<Book> books = new ArrayList<>();

    public StudentsController() {
    }

    private void refreshBooks() {
        studentsBooks = studentsService
                .findByUsername(loginController.getRemoteUser())
                .getBooks();
    }

    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        students = studentsService.findByUsername(loginController.getRemoteUser());
        refreshBooks();
        book = new Book();
        book.setType(new BookType());
        book.setStudents(students);

    }

    public List<Book> displaybook() {

        books = bookService.findAll();
        //book = bookService.findByUsername(loginController.getRemoteUser());
        return books;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}

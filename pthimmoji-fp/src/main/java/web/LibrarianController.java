/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Book;
import model.BookType;
import model.Librarian;
import model.Students;
import model.security.User;
import service.BookService;
import service.GroupService;
import service.LibrarianService;
import service.StudentsService;
import service.UserService;

/**
 * Libarian Controller
 * @author Pratibha T S
 */
@Named
@RequestScoped
public class LibrarianController extends BaseController {
    
private static final Logger LOG = Logger.getLogger(LibrarianController.class.getName());
    @Inject LoginController loginController;
    @Inject StudentsController studentController; 
    @EJB LibrarianService librarianService;
     @EJB BookService bookService;
     @EJB StudentsService studentService;
     @EJB UserService userservice;
     @EJB GroupService groupservice;
    private Librarian librarian;
    private Book book;
    private Students student;
    private User user;

    
    List<Book> librarianBooks = new ArrayList<>();
    List<Students> librarianStudents = new ArrayList<>();
    List<User> userObject=new ArrayList<>();
    
    public LibrarianController() {
    }
    
    private void refreshBooks() {
        librarianBooks = librarianService
                .findByUsername(loginController.getRemoteUser())
                .getBooks();
    }

    private void refreshStudents() {
        librarianStudents = librarianService
                .findByUsername(loginController.getRemoteUser())
                .getStudents();
    }
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
        librarian = librarianService.findByUsername(loginController.getRemoteUser());

        
        refreshBooks();
        refreshStudents();
        
        student = new Students();
        student.setUser(new User());
        student.setLibrarian(librarian);

        book = new Book();
        book.setType(new BookType());
        book.setLibrarian(librarian);

    }
 public String doCreate() {
        LOG.info("inside doCreatePet with " + librarian.toString());

        // make sure the pet is clean and empty
        book = new Book();
        book.setType(new BookType());
        book.setLibrarian(librarian);

        return loginController.conditionalizeContextPath("editBook.xhtml");
    }
 
 public String doCreateStudent() {
        LOG.info("inside doCreatePet with " + librarian.toString());
       
        student=new Students();
        student.setUser(new User());
        student.setLibrarian(librarian);
        
//         if (this.user.getUserName()!= null && this.user.getPassword()!= null )
//       user.setUserName("userName");
       
//        
//              userservice.create(user);
        
        // make sure the pet is clean and empty
//        student=new Students();
//        student.setLibrarian(librarian);
         //student.setUser(new User());

        return loginController.conditionalizeContextPath("editStudent.xhtml");
    }

    // stage 1 of update.  set the selected pet from dataTable
    // and route user to form to edit pet
    public String doUpdate(Book p) {
        this.book = p;
        LOG.info("inside doUpdateBook with " + p.toString());
        return loginController.conditionalizeContextPath("editBook.xhtml");
    }
    
     public String doUpdates(Students p) {
        this.student = p;
        LOG.info("inside doUpdateStudent with " + p.toString());
        return loginController.conditionalizeContextPath("editStudent.xhtml");
    }

    public String executeUpdate() {
        LOG.info("inside executeUpdate with " + this.book.toString());
        if (this.book.getId()!= null) {
            LOG.info("Updating book " + this.book.toString());
            bookService.update(book);

        } else {
            LOG.info("Creating new book " + this.book.toString());
            bookService.create(book);
        }

        return loginController.conditionalizeContextPath("welcome.xhtml?faces-redirect=true");
    }
    
    public String executeUpdateStudent()
    {
        if (this.student.getId()!= null) {
            LOG.info("Updating book " + this.book.toString());
          // student.getUser().addGroup(groupservice.findGroupByName("STUDENTS"));
            student.getUser().setPassword("password");
           //  userservice.create(student.getUser());
            // userservice.update(student.getUser());
            
            
          //  sec_user,sec_use_gro
          
         
        //  userservice.updates(student.getUser());
          //student.getUser().addGroup(groupservice.findGroupByName("STUDENTS"));
            bookService.updates(student);
        } else {
            LOG.info("Creating new student" + this.student.toString());
//                librarian.addStudent(student);
//              student.getLibrarian().addStudent(student);
              librarianStudents=studentService.findAll();
              
              librarian.setStudents(librarianStudents);
              student.setLibrarian(librarian);
             student.getUser().addGroup(groupservice.findGroupByName("STUDENTS"));
            student.getUser().setPassword("password");
            userservice.create(student.getUser());
            bookService.createS(student);
        }
        return loginController.conditionalizeContextPath("welcome.xhtml?faces-redirect=true");
    }

    // set the selected pet from dataTable
    // route user to a JSF view to inspect the pet (read-only)
    public String doView(Book p) {
        this.book = p;
        LOG.info("inside doViewBook with " + p.toString());
        return loginController.conditionalizeContextPath("book.xhtml");
    }
    
     public String doViews(Students p) {
        this.student = p;
        //LOG.info("inside doViewBook with " + p.toString());
        return loginController.conditionalizeContextPath("student.xhtml");
    }

    public String doDelete(Book p) {
        this.book = p;
        LOG.info("inside doDeleteBook with " + p.toString());
        bookService.remove(p);
        return loginController.conditionalizeContextPath("welcome.xhtml?faces-redirect=true");
    }
    
       public String doDeletes(Students p) {
        this.student = p;
        LOG.info("inside doDeleteBook with " + p.toString());
        bookService.removes(p);
        return loginController.conditionalizeContextPath("welcome.xhtml?faces-redirect=true");
    }
       

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getLibrarianBooks() {
        return librarianBooks;
    }

    public void setLibrarianBooks(List<Book> librarianBooks) {
        this.librarianBooks = librarianBooks;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public List<Students> getLibrarianStudents() {
        return librarianStudents;
    }

    public void setLibrarianStudents(List<Students> librarianStudents) {
        this.librarianStudents = librarianStudents;
    }
    
    

}

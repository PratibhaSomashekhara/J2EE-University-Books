/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Author;
import model.Book;
import model.BookType;
import model.Librarian;
import model.Students;
import model.security.User;

/**
 * Services pertaining to books
 * @author Lenovo
 */
@Named
@Stateless
public class BookService {

    @PersistenceContext(unitName = "pthimmojiPU")
    private EntityManager em;

    public BookService() {
    }

    // Create
    public void create(Book p) {
        //em.persist(p);
        Librarian o = em.getReference(Librarian.class, p.getLibrarian().getId());
        o.addBook(p);
        p.setType(em.getReference(BookType.class, p.getType().getId()));

        em.persist(p);
    }
    //create Student

    public void createS(Students p) {
        //em.persist(p);
        Librarian o = em.getReference(Librarian.class, p.getLibrarian().getId());
        o.addStudent(p);
        p.setUser(em.getReference(User.class, p.getUser().getUserName()));

        em.persist(p);
    }

    // Read
    public Book find(int i) {
        return em.find(Book.class, i);
    }

    //Read students
    public Students finds(int i) {
        return em.find(Students.class, i);
    }

    // Update
    // JTA is managing the transaction!
    public void update(Book updatedBook) {
        // this is not going to cut it
        //em.merge(p);

        Book existingPet = find(updatedBook.getId());

        updatedBook.setLibrarian(existingPet.getLibrarian());
        updatedBook.setType(em.getReference(BookType.class, updatedBook.getType().getId()));

        em.merge(updatedBook);
    }

    //updates students records
    public void updates(Students updatedStudent) {

        Students existingStudent = finds(updatedStudent.getId());

        updatedStudent.setLibrarian(existingStudent.getLibrarian());
        updatedStudent.setUser(em.getReference(User.class, updatedStudent.getUser().getUserName()));

        em.merge(updatedStudent);
    }

    // Delete
    public void remove(Book p) {
        // this is not going to cut it
        //em.remove(em.merge(p));

        // first, lets attach it
        p = em.getReference(Book.class, p.getId());

        // handle owner
        p.getLibrarian().removeBook(p);

        // handle visits
        for (Author v : p.getAuthors()) {
            // should handle both sides of the relationship, by removing
            // the visit from the pet - and the pet from the visit
            // BUT, I'm just deleting the pet anyway... so short-circuit
            // and just remove the visit since the pet is being removed anyway
            em.remove(v);
        }

        // finally, I can remove the pet safely
        em.remove(p);
    }

    public void removes(Students p) {
        // this is not going to cut it
        //em.remove(em.merge(p));

        // first, lets attach it
        p = em.getReference(Students.class, p.getId());

        // handle owner
        p.getLibrarian().removeStudent(p);
        // finally, I can remove the pet safely
        em.remove(p);
    }

    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }

    public Book findByUsername(String username) {
        return em.createNamedQuery("Book.findByUsername", Book.class).setParameter("userName", username).getSingleResult();
    }
//     public List<Students> findAlls() {
//        return em.createNamedQuery("Students.findAll", Students.class).getResultList();
//    }
}

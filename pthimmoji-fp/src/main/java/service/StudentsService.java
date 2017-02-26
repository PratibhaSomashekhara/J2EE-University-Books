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
import model.Book;
import model.Librarian;
import model.Students;
import model.security.User;

/**
 * Student Services
 * @author Lenovo
 */
@Named
@Stateless
public class StudentsService {
   
       @PersistenceContext(unitName = "pthimmojiPU")
    private EntityManager em;

    
    
    public StudentsService() {
    }
    
 public void create(Students stu) 
 {    
     //System.out.println(stu.getLibrarian().getId());
  // Librarian o = em.getReference(Librarian.class, stu.getLibrarian().getId());
   // o.addStudent(stu);
     stu.setUser(em.getReference(User.class, stu.getUser().getUserName()));      
       em.persist(stu);
    }
 
  public Students find(int i) {
        return em.find(Students.class, i);
    }
  
  //Update the student record
    public void update(Students updatedStudent)
    {
        Students existingStudent = find(updatedStudent.getId());
        updatedStudent.setLibrarian(existingStudent.getLibrarian());
        updatedStudent.setUser(em.getReference(User.class, updatedStudent.getUser().getUserName()));   
        
        em.merge(updatedStudent);
    }
    // Delete
     public void remove(Students p) {
        p = em.getReference(Students.class, p.getId());
        p.getLibrarian().removeStudent(p);
        em.remove(p);
    }

    public List<Students> findAll()
    {
        return em.createNamedQuery("Students.findAll", Students.class).getResultList();
    }

    public Students findByUsername(String username)
    {
        return em.createNamedQuery("Students.findByUsername", Students.class).setParameter("userName", username).getSingleResult();
    }
    
     public List<Book> findAlls() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Book;
import model.BookType;
import model.Librarian;
import model.security.User;

/**
 * User Services
 * @author Pratibha
 */
@Stateless
public class UserService extends BaseService<User>{

    
     @PersistenceContext(unitName = "pthimmojiPU")
    private EntityManager em;
     
    public UserService() {
        super(User.class);
    }
 public void create(User user) {
        //em.persist(p);
//      Librarian o = em.getReference(Librarian.class, p.getLibrarian().getId());
//        o.addBook(p);
//        p.setType(em.getReference(BookType.class, p.getType().getId()));
//        
//        em.persist(p);
em.persist(user);
    }
 
 public void updates(User user)
 {
 
 em.merge(user);
 }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

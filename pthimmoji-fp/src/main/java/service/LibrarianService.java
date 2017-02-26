/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import model.Librarian;
import model.Students;


/**
 * Librarian Services
 * @author Lenovo
 */
@Named
@Stateless
public class LibrarianService extends BaseService<Librarian>{
   public LibrarianService() {
        super(Librarian.class);
    }

    @Override
    public List<Librarian> findAll() {
    
        return getEntityManager().createNamedQuery("Librarian.findAll", Librarian.class).getResultList();
    }

    public Librarian findByUsername(String username){
        return getEntityManager().createNamedQuery("Librarian.findByUsername", Librarian.class).setParameter("userName", username).getSingleResult();
    }
    
       public Students findByUsernameS(String username)
    {
        return getEntityManager().createNamedQuery("Students.findByUsername", Students.class).setParameter("userName", username).getSingleResult();
    }
}

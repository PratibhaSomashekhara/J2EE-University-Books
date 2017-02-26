/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import model.Author;


/**
 *
 * @author Lenovo
 */
@Stateless
public class AuthorService extends BaseService<Author> {
    public AuthorService() {
        super(Author.class);
    }

    @Override
    public List<Author> findAll() {
        // select o from Owner o
        return getEntityManager().createNamedQuery("Author.findAll", Author.class).getResultList();
    } 
    
}

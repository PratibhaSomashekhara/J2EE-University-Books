/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import java.util.List;
import javax.ejb.Stateless;
import model.Publisher;

/**
 * Publisher Services
 * @author Lenovo
 */
@Stateless
public class PublisherService extends BaseService<Publisher>{

   public PublisherService() {
        super(Publisher.class);
    }

    @Override
    public List<Publisher> findAll() {
        // select o from Owner o
        return getEntityManager().createNamedQuery("Publisher.findAll", Publisher.class).getResultList();
    } 
    
    
    
}

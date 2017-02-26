/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * acts as a base service for other services
 * @author Pratibha Thimmoji
 */
public abstract class BaseService<T> {

    private final Class<T> entityClass;
    
    @PersistenceContext(unitName ="pthimmojiPU")
    private EntityManager em;

    protected BaseService(Class entityClass) {
        this.entityClass = entityClass;
    }
    
    public EntityManager getEntityManager() {
        return em;
    }

    // Create
    public void create(T entity){
        em.persist(entity);
    }

    // Read   
    public T find(Object id){
        return em.find(entityClass, id);
    }
    
    // this could work - needs testing
    // basically same signature as https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html#find-java.lang.Class-java.lang.Object-
    public <T> T read(Class<T> entityClass, Object id){
        return em.find(entityClass, id);
    }
    
    public abstract List<T> findAll();
    
    //Update
    public void update(T entity){
        em.merge(entity);
    }
    
    //Delete
    public void delete(T entity){
        em.remove(em.merge(entity));
    }
    
}

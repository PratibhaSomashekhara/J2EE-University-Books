/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import model.BookType;


/**
 * Services for book types
 * @author Pratibha Thimmoji
 */
@Named
@Stateless
public class BookTypeService extends BaseService<BookType> {

    public BookTypeService() {
        super(BookType.class);
    }

    @Override
    public List<BookType> findAll() {
        return getEntityManager().createQuery("select t from BookType t", BookType.class).getResultList();
    }

}

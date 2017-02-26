/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This contains details about the type of the books
 * @author Lenovo
 * 
 *book can be fictions novels magazines 
 */
@Entity
@Table(name = "types")
public class BookType extends NamedEntity {
    
}

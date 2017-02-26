/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import model.Librarian;
import model.Students;
import model.security.Group;
import model.security.User;

/**
 * Intializes the application
 * @author Pratibha
 */
@Startup
@Singleton
public class AppInitializer {

    @EJB UserService userService;
    @EJB GroupService groupService;
    @EJB StudentsService studentsService;
    @EJB LibrarianService librarianService;
    
    public AppInitializer() {
    }
    
    @PostConstruct
    private void appInit(){
        
        // creating a new security user
        User student3 = new User("student4","student4");
        // and associating the security user with an existing group/role
        Group studentsGroup = groupService.findGroupByName("STUDENTS");
        student3.addGroup(studentsGroup);
        
        
        // creating a new vet (business user)
        Students student4 = new Students("Pratibha", "Thimmoji");
        // AND associating the security user with the business user
        student4.setUser(student3);
        
        userService.create(student3);
        studentsService.create(student4);
        
        
        // creating a new security user
        User librarian4 = new User("librarian4","librarian4");
        // and associating the security user with an existing group/role
        Group librarianGroup = groupService.findGroupByName("LIBRARIAN");
        librarian4.addGroup(librarianGroup);
        
        
        // creating a new LIBRARIAN (business user)
        Librarian librarian5 = new Librarian("Amit", "Shah");
        // AND associating the security user with the business user
        librarian5.setUser(librarian4);
        
        userService.create(librarian4);
        librarianService.create(librarian5);
        
//        Group adminGroup = new Group("ADMINISTRATORS", "Adin group");
//        User adminUser = new User("admin", "admin");
//        adminUser.addGroup(adminGroup);
//        
//        groupService.create(adminGroup);
//        userService.create(adminUser);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Lenovo
 */
@Named(value = "studentsJSFManagedBean")
@ApplicationScoped
public class StudentsJSFManagedBean {

    private List<Students> students =new ArrayList<>();
    
    
    /**
     * Creates a new instance of StudentsJSFManagedBean
     */
    public StudentsJSFManagedBean() {
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
    
    
}

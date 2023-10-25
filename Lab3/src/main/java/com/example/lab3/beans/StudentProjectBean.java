package com.example.lab3.beans;

// Import statements...

import com.example.lab3.dao.StudentProjectDAO;
import com.example.lab3.entities.Project;
import com.example.lab3.entities.Student;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class StudentProjectBean {
    public StudentProjectBean() {
        // ...
    }

}

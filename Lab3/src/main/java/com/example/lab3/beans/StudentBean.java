package com.example.lab3.beans;
import com.example.lab3.dao.StudentDAO;
import com.example.lab3.entities.Student;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class StudentBean {
    private List<Student> students;

    public StudentBean() {
        // Initialize the list of projects from your database
        students = StudentDAO.getAllStudents();
    }

    public List<Student> getStudents() {
        return students;
    }
}

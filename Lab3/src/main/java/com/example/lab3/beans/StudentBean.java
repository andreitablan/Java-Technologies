package com.example.lab3.beans;

import com.example.lab3.dao.StudentDAO;
import com.example.lab3.dao.StudentProjectDAO;
import com.example.lab3.entities.Project;
import com.example.lab3.entities.Student;
import com.example.lab3.entities.StudentProject;
import org.primefaces.model.DualListModel;

import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class StudentBean {
    private ProjectBean projectBean;
    private String name = ""; // Initialize with an empty string
    private List<Project> availableProjects;
    private DualListModel<Project> projectsDualList;
    private List<Student> students;
    private Student selectedStudent; // Field to hold the selected student for editing

    public StudentBean() {
        students = StudentDAO.getAllStudents();
        projectBean = new ProjectBean();
        availableProjects = projectBean.getProjects();
        projectsDualList=new DualListModel<>(availableProjects, new ArrayList<>());
        if(projectsDualList !=null)
            System.out.println("size");
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Project> getProjectsForStudent(Student student) {
        return StudentProjectDAO.getProjectsForStudent(student);
    }

    public void saveStudent() {
        System.out.println("saveStudent " + name);
        Student insertedStudent = StudentDAO.insertStudent(name);

        // Update the list of students
        students = StudentDAO.getAllStudents();
        name = null; // Clear the newStudent form after saving
    }

    public void openEditDialog(Student student) {
        selectedStudent = student;
    }
/*
    public void saveEditedStudent() {
        if (selectedStudent != null) {
            // Call the DAO method to update the student in the database
            StudentDAO.updateStudent(selectedStudent);
            selectedStudent = null; // Clear the selected student
        }
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public DualListModel<Project> getProjectsDualList() {
        return projectsDualList;
    }

    public void setProjectsDualList(DualListModel<Project> projectDualListModel) {
        this.projectsDualList = projectDualListModel;
    }
    public List<Project> getAvailableProjects() {
        return this.availableProjects;
    }

    public void setAvailableProjects(List<Project> availableProjects) {
        this.availableProjects = availableProjects;
    }
    public ProjectBean getProjectBean() {
        return projectBean;
    }

    public void setProjectBean(ProjectBean projectBean) {
        this.projectBean = projectBean;
    }
    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
}

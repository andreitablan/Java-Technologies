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
    private String name = "";
    private List<Project> availableProjects=new ArrayList<>();
    private DualListModel<String> projectsDualList;
    private List<Student> students;
    private Student selectedStudent;

    public StudentBean() {
        students = StudentDAO.getAllStudents();
        projectBean = new ProjectBean();
        availableProjects = projectBean.getProjects();
        List<String> projectsSource = new ArrayList<>();
        for(Project p:availableProjects){
            projectsSource.add(p.getName());
        }
        List<String> projectsTarget = new ArrayList<>();
        projectsDualList=new DualListModel<>(projectsSource, projectsTarget);
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
        List<Project> selectedProjects = new ArrayList<>();
        for(String projectName:projectsDualList.getTarget()){
            if(findProjectByName(projectName)!=null)
                selectedProjects.add(findProjectByName(projectName));
        }
        StudentProjectDAO.updateStudentProjects(insertedStudent, selectedProjects);
        students = StudentDAO.getAllStudents();
        name = null;
    }

    public void deleteStudent(Student student) {
        StudentDAO.deleteStudent(student);
        students = StudentDAO.getAllStudents();
    }

    public void openEditDialog(Student student) {
        selectedStudent = student;
    }
    public void openEditProjectsDialog(Student student) {
        selectedStudent = student;
    }

    public void saveEditedStudent() {
        if (selectedStudent != null) {
            // Call the DAO method to update the student in the database
            StudentDAO.updateStudent(selectedStudent);
            selectedStudent = null; // Clear the selected student
        }
    }
    public void saveEditedStudentProjects() {
        if (selectedStudent != null) {
            List<Project> selectedProjects = new ArrayList<>();
            for(String projectName:projectsDualList.getTarget()){
                if(findProjectByName(projectName)!=null)
                    selectedProjects.add(findProjectByName(projectName));
            }
            StudentProjectDAO.updateStudentProjects(selectedStudent, selectedProjects);
            selectedStudent = null;
        }
    }
    private Project findProjectByName(String name) {
        for (Project project : availableProjects) {
            if (project.getName().equals(name)) {
                return project;
            }
        }
        return null;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public DualListModel<String> getProjectsDualList() {
        return projectsDualList;
    }

    public void setProjectsDualList(DualListModel<String> projectDualListModel) {
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

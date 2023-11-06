package com.example.lab3.beans;

import com.example.lab3.entity.Project;
import com.example.lab3.entity.Student;
import com.example.lab3.repository.StudentRepository;
import com.example.lab3.repository.StudentProjectRepository;
import org.primefaces.model.DualListModel;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Student bean for the management of the students
 */
@Named
@RequestScoped
public class StudentBean {

    @Inject
    private StudentRepository studentRepository;
    @Inject
    private StudentProjectRepository studentProjectRepository;

    private ProjectBean projectBean;
    private String name = "";
    private List<Project> availableProjects;
    private DualListModel<String> projectsDualList;
    private List<Student> students;
    private Student selectedStudent;
    private Date lastModifiedTimestamp;

    public StudentBean() {
        students = studentRepository.findAllStudents();
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
        return studentProjectRepository.getProjectsForStudent(student);
    }

    public void saveStudent() {
        lastModifiedTimestamp = new Date();

        Student insertedStudent = studentRepository.insertStudent(name);
        List<Project> selectedProjects = new ArrayList<>();
        for(String projectName:projectsDualList.getTarget()){
            if(findProjectByName(projectName)!=null)
                selectedProjects.add(findProjectByName(projectName));
        }
        studentProjectRepository.updateStudentProjects(insertedStudent, selectedProjects);
        students = studentRepository.findAllStudents();
        name = null;
    }

    public void deleteStudent(Student student) {
        studentRepository.deleteStudent(student);
        students = studentRepository.findAllStudents();
    }

    public void openEditDialog(Student student) {
        selectedStudent = student;
    }
    public void openEditProjectsDialog(Student student) {
        selectedStudent = student;
    }

    public void saveEditedStudent() {
        if (selectedStudent != null) {
            studentRepository.updateStudent(selectedStudent);
            selectedStudent = null;
        }
    }
    public void saveEditedStudentProjects() {
        if (selectedStudent != null) {
            List<Project> selectedProjects = new ArrayList<>();
            for(String projectName:projectsDualList.getTarget()){
                if(findProjectByName(projectName)!=null)
                    selectedProjects.add(findProjectByName(projectName));
            }
            studentProjectRepository.updateStudentProjects(selectedStudent, selectedProjects);
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
    public Date getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }
}

package com.example.lab3;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class ProjectBean {
    private List<Project> projects;

    public ProjectBean() {
        // Initialize the list of projects from your database
        projects = ProjectDAO.getAllProjects();
    }

    public List<Project> getProjects() {
        return projects;
    }
}

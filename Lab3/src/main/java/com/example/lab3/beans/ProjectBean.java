package com.example.lab3.beans;

import com.example.lab3.dao.ProjectDAO;
import com.example.lab3.entities.Project;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@RequestScoped
@SessionScoped
public class ProjectBean {
    private List<Project> projects;
    private String name;
    private String description;
    private String category;
    private Date deadline;
    private Project selectedProject;

    public ProjectBean() {
        projects = ProjectDAO.getAllProjects();
    }

    public List<Project> getProjects() {
        return projects;
    }
    public void saveProject() {
        if (deadline != null) {
                Logger logger = Logger.getLogger(getClass().getName());

                logger.log(Level.INFO, "Save Project called");

                java.sql.Date sqlDate = new java.sql.Date(deadline.getTime());

                logger.log(Level.INFO, "sqlDate: " + sqlDate);

                Project newProject = new Project(15, name, category, description, sqlDate);
                if(newProject !=null)
                    System.out.println("project not null");
                ProjectDAO.addProject(newProject);

                logger.log(Level.INFO, "Project added to the database");

                projects = ProjectDAO.getAllProjects(); // Refresh the project list after adding a new project
                name = "";
                description = "";
                category = "";
                deadline = null;
        }
    }

    public void openEditDialog(Project project) {
        selectedProject = project;
    }

    public void saveEditedProject() {
        if (selectedProject != null && deadline != null) {
            selectedProject.setDeadline(new java.sql.Date(deadline.getTime()));
            ProjectDAO.updateProject(selectedProject);
            selectedProject = null;
        }
    }
    public void deleteProject(Project project) {
        ProjectDAO.deleteProject(project);
        projects.remove(project);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Project getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Project selectedProject) {
        this.selectedProject = selectedProject;
    }
}

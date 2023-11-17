package com.example.laboratory5.beans;

import com.example.laboratory5.entity.Project;
import com.example.laboratory5.repository.ProjectRepository;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Project bean for the project management
 */
@Named
@RequestScoped
public class ProjectBean {
    @Inject
    private ProjectRepository projectRepository;
    private List<Project> projects;
    private String name;
    private String description;
    private String category;
    private Date deadline;
    private Project selectedProject;
    private Date lastModifiedTimestamp;

    @PostConstruct
    public void init() {
        projects = projectRepository.getAllProjects();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void saveProject() {
        if (deadline != null) {
                lastModifiedTimestamp = new Date();
                java.sql.Date sqlDate = new java.sql.Date(deadline.getTime());

                Project project = new Project();
                project.setName(name);
                project.setDescription(description);
                project.setCategory(category);
                project.setDeadline(sqlDate);
                projectRepository.saveProject(project);

                projects = projectRepository.getAllProjects();
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
            projectRepository.updateProject(selectedProject);
            selectedProject = null;
        }
    }
    public void deleteProject(Project project) {
        projectRepository.deleteProject(project);
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

    public Date getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }
}

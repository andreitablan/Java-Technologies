package com.example.lab5.beans;

import com.example.lab5.entity.Projects;
import com.example.lab5.repository.ProjectRepository;
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
    private List<Projects> projects;
    private String name;
    private String description;
    private String category;
    private Date deadline;
    private Projects selectedProject;
    private Date lastModifiedTimestamp;

    public ProjectBean() {
        projects = projectRepository.getAllProjects();
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void saveProject() {
        if (deadline != null) {
                lastModifiedTimestamp = new Date();
                java.sql.Date sqlDate = new java.sql.Date(deadline.getTime());

                Projects project = new Projects();
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

    public void openEditDialog(Projects project) {
        selectedProject = project;
    }

    public void saveEditedProject() {
        if (selectedProject != null && deadline != null) {
            selectedProject.setDeadline(new java.sql.Date(deadline.getTime()));
            projectRepository.updateProject(selectedProject);
            selectedProject = null;
        }
    }
    public void deleteProject(Projects project) {
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

    public Projects getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Projects selectedProject) {
        this.selectedProject = selectedProject;
    }

    public Date getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }
}

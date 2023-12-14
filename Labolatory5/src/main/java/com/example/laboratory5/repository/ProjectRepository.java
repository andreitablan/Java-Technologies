package com.example.laboratory5.repository;

import com.example.laboratory5.entity.Project;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import java.util.List;

/**
 * Repository for the project entity
 */
@RequestScoped
public class ProjectRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public List<Project> getAllProjects() {
        List<Project> projects =  entityManager.createNamedQuery("Project.findAll", Project.class).getResultList();
        if(projects != null && !projects.isEmpty()){
            System.out.println("Projects are not empty!");
        }
        else {
            System.out.println("Projects are empty!");
        }
        return projects;
    }

    public Project getProjectById(int id) {
        return entityManager.createNamedQuery("Project.findById", Project.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void saveProject(Project project) {
        entityManager.persist(project);
    }

    public void updateProject(Project project) {
        entityManager.merge(project);
    }

    public void deleteProject(Project project) {
        Project managedProject = entityManager.find(Project.class, project.getId());
        if (managedProject != null) {
            entityManager.remove(managedProject);
        }
    }
}

package com.example.lab3.repository;

import com.example.lab3.entity.Projects;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
@ApplicationScoped
public class ProjectRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public List<Projects> getAllProjects() {
        List<Projects> projects =  entityManager.createNamedQuery("Project.findAll", Projects.class).getResultList();
        if(projects != null && !projects.isEmpty()){
            System.out.println("Projects are not empty!");
        }
        else {
            System.out.println("Projects are empty!");
        }
        return projects;
    }

    public Projects getProjectById(int id) {
        return entityManager.createNamedQuery("Project.findById", Projects.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public void saveProject(Projects project) {
        entityManager.persist(project);
    }

    @Transactional
    public void updateProject(Projects project) {
        entityManager.merge(project);
    }

    @Transactional
    public void deleteProject(Projects project) {
        Projects managedProject = entityManager.find(Projects.class, project.getId());
        if (managedProject != null) {
            entityManager.remove(managedProject);
        }
    }
}

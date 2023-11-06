package com.example.lab3.repository;
import com.example.lab3.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@ApplicationScoped
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

    @Transactional
    public void saveProject(Project project) {
        entityManager.persist(project);
    }

    @Transactional
    public void updateProject(Project project) {
        entityManager.merge(project);
    }

    @Transactional
    public void deleteProject(Project project) {
        Project managedProject = entityManager.find(Project.class, project.getId());
        if (managedProject != null) {
            entityManager.remove(managedProject);
        }
    }
}

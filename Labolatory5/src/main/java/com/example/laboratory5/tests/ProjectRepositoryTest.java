package com.example.laboratory5.tests;

import com.example.laboratory5.entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

public class ProjectRepositoryTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void setUp() {
        emf = Persistence.createEntityManagerFactory("ExamplePU");
        em = emf.createEntityManager();
    }

    public void tearDown() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    public void testJPA() {
        // Persist a project
        em.getTransaction().begin();
        Project project = new Project();
        project.setName("ProjectA");
        project.setCategory("CategoryA");
        project.setDescription("DescriptionA");
        project.setDeadline(Date.valueOf("2023-12-31"));
        em.persist(project);
        em.getTransaction().commit();

        // Retrieve the project
        em.getTransaction().begin();
        TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p WHERE p.name = 'ProjectA'", Project.class);
        Project retrievedProject = query.getSingleResult();
        assertEquals("ProjectA", retrievedProject.getName());

        // Update the project
        retrievedProject.setDescription("UpdatedDescription");
        em.getTransaction().commit();

        // Verify the update
        em.getTransaction().begin();
        Project updatedProject = em.find(Project.class, retrievedProject.getId());
        assertEquals("UpdatedDescription", updatedProject.getDescription());
        em.getTransaction().commit();
    }

}

package com.example.lab3.repository;

import com.example.lab3.entity.Projects;
import com.example.lab3.entity.StudentProjects;
import com.example.lab3.entity.Students;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StudentProjectRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public List<Projects> getProjectsForStudent(Students student) {
        TypedQuery<Projects> query = entityManager.createNamedQuery("StudentProject.getProjectsForStudent", Projects.class);
        query.setParameter("studentId", student.getId());
        return query.getResultList();
    }

    public void deleteStudentProjects(Students student) {
        entityManager.createNamedQuery("StudentProject.deleteStudentProjects")
                .setParameter("studentId", student.getId())
                .executeUpdate();
    }
    @Transactional
    public void updateStudentProjects(Students student, List<Projects> projects) {
        deleteStudentProjects(student);
        for (Projects project : projects) {
            StudentProjects studentProject = new StudentProjects();
            studentProject.setStudentId(student.getId());
            studentProject.setProjectId(project.getId());
            entityManager.persist(studentProject);
        }
    }
}


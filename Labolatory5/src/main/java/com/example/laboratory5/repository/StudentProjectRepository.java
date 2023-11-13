package com.example.laboratory5.repository;

import com.example.laboratory5.entity.Project;
import com.example.laboratory5.entity.StudentProjects;
import com.example.laboratory5.entity.Student;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Repository for the student-project entity
 */
@ApplicationScoped
public class StudentProjectRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public List<Project> getProjectsForStudent(Student student) {
        TypedQuery<Project> query = entityManager.createNamedQuery("StudentProject.getProjectsForStudent", Project.class);
        query.setParameter("studentId", student.getId());
        return query.getResultList();
    }

    public void deleteStudentProjects(Student student) {
        entityManager.createNamedQuery("StudentProject.deleteStudentProjects")
                .setParameter("studentId", student.getId())
                .executeUpdate();
    }
    @Transactional
    public void updateStudentProjects(Student student, List<Project> projects) {
        deleteStudentProjects(student);
        for (Project project : projects) {
            StudentProjects studentProject = new StudentProjects();
            studentProject.setStudentId(student.getId());
            studentProject.setProjectId(project.getId());
            entityManager.persist(studentProject);
        }
    }
}


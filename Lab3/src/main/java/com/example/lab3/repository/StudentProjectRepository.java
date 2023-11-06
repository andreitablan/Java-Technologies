package com.example.lab3.repository;
import com.example.lab3.entity.Project;
import com.example.lab3.entity.Student;
import com.example.lab3.entity.StudentProject;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
            StudentProject studentProject = new StudentProject();
            studentProject.setStudentId(student.getId());
            studentProject.setProjectId(project.getId());
            entityManager.persist(studentProject);
        }
    }
}


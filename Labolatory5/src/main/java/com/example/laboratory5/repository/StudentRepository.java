package com.example.laboratory5.repository;
import com.example.laboratory5.entity.Student;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
/**
 * Repository for the student entity
 */
@ApplicationScoped
public class StudentRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public List<Student> findAllStudents() {
        List<Student> students= entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
        if(students != null && !students.isEmpty()){
            System.out.println("Students are not empty!");
        }
        else {
            System.out.println("Students are empty!");
        }
        return students;
    }

    public Student findStudentById(int id) {
        return entityManager.createNamedQuery("Student.findById", Student.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public Student insertStudent(String name) {
        Student student = new Student();
        student.setName(name);
        entityManager.persist(student);
        return student;
    }

    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    public void deleteStudent(Student student) {
        Student managedStudent = entityManager.find(Student.class, student.getId());
        if (managedStudent != null) {
            entityManager.remove(managedStudent);
        }
    }
}



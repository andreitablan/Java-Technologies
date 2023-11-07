package com.example.labolatory5.repository;

import com.example.labolatory5.entity.Students;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
@ApplicationScoped
public class StudentRepository {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    public List<Students> findAllStudents() {
        List<Students> students= entityManager.createNamedQuery("Student.findAll", Students.class).getResultList();
        if(students != null && !students.isEmpty()){
            System.out.println("Students are not empty!");
        }
        else {
            System.out.println("Students are empty!");
        }
        return students;
    }

    public Students findStudentById(int id) {
        return entityManager.createNamedQuery("Student.findById", Students.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    public Students insertStudent(String name) {
        Students student = new Students();
        student.setName(name);
        entityManager.persist(student);
        return student;
    }

    @Transactional
    public void updateStudent(Students student) {
        entityManager.merge(student);
    }

    @Transactional
    public void deleteStudent(Students student) {
        Students managedStudent = entityManager.find(Students.class, student.getId());
        if (managedStudent != null) {
            entityManager.remove(managedStudent);
        }
    }
}



package com.example.lab5.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "public", catalog = "postgres")
@NamedQueries({
        @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
        @NamedQuery(name = "Students.findById", query = "SELECT s FROM Students s WHERE s.id = :id")
})
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
//    @OneToMany(mappedBy = "studentsByStudentId")
//    private Collection<StudentProjects> studentProjectsById;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && Objects.equals(name, students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

//    public Collection<StudentProjects> getStudentProjectsById() {
//        return studentProjectsById;
//    }
//
//    public void setStudentProjectsById(Collection<StudentProjects> studentProjectsById) {
//        this.studentProjectsById = studentProjectsById;
//    }
}

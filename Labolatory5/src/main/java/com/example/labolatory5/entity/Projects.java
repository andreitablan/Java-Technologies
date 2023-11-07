package com.example.labolatory5.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "projects", schema = "public", catalog = "postgres")
@NamedQueries({
        @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Projects p"),
        @NamedQuery(name = "Project.findById", query = "SELECT p FROM Projects p WHERE p.id = :id")
})
public class Projects {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "deadline")
    private Date deadline;
    @OneToMany(mappedBy = "projectsByProjectId")
    private Collection<StudentProjects> studentProjectsById;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projects projects = (Projects) o;
        return id == projects.id && Objects.equals(name, projects.name) && Objects.equals(category, projects.category) && Objects.equals(description, projects.description) && Objects.equals(deadline, projects.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, description, deadline);
    }

    public Collection<StudentProjects> getStudentProjectsById() {
        return studentProjectsById;
    }

    public void setStudentProjectsById(Collection<StudentProjects> studentProjectsById) {
        this.studentProjectsById = studentProjectsById;
    }
}

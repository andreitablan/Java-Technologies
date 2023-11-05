package com.example.lab3.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "projects", schema = "public", catalog = "postgres")
@NamedQueries({
        @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
        @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id")
})
public class Project {
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
    private Collection<StudentProject> studentProjectsById;

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
        Project project = (Project) o;
        return id == project.id && Objects.equals(name, project.name) && Objects.equals(category, project.category) && Objects.equals(description, project.description) && Objects.equals(deadline, project.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, description, deadline);
    }

    public Collection<StudentProject> getStudentProjectsById() {
        return studentProjectsById;
    }

    public void setStudentProjectsById(Collection<StudentProject> studentProjectsById) {
        this.studentProjectsById = studentProjectsById;
    }
}

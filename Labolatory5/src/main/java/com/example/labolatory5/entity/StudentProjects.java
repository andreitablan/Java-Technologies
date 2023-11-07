package com.example.labolatory5.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student_projects", schema = "public", catalog = "postgres")
@NamedQueries({
        @NamedQuery(name = "StudentProject.getProjectsForStudent",
                query = "SELECT p.id, p.name, p.category, p.description, p.deadline FROM Projects p INNER JOIN StudentProjects sp ON p.id = sp.projectId WHERE sp.studentId = :studentId"),
        @NamedQuery(name = "StudentProject.deleteStudentProjects",
                query = "DELETE FROM StudentProjects sp WHERE sp.studentId = :studentId")
})
public class StudentProjects {
    @Basic
    @Column(name = "student_id")
    private Integer studentId;
    @Basic
    @Column(name = "project_id")
    private Integer projectId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Students studentsByStudentId;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Students projectsByProjectId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentProjects that = (StudentProjects) o;
        return id == that.id && Objects.equals(studentId, that.studentId) && Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, projectId, id);
    }

    public Students getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(Students studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    public Students getProjectsByProjectId() {
        return projectsByProjectId;
    }

    public void setProjectsByProjectId(Students projectsByProjectId) {
        this.projectsByProjectId = projectsByProjectId;
    }
}

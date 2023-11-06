package com.example.lab3.entity;

import javax.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "student_projects", schema = "public", catalog = "postgres")
@NamedQueries({
        @NamedQuery(name = "StudentProject.getProjectsForStudent",
                query = "SELECT p.id, p.name, p.category, p.description, p.deadline FROM Project p INNER JOIN StudentProject sp ON p.id = sp.projectId WHERE sp.studentId = :studentId"),
        @NamedQuery(name = "StudentProject.deleteStudentProjects",
                query = "DELETE FROM StudentProject sp WHERE sp.studentId = :studentId")
})
public class StudentProject {
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
        StudentProject that = (StudentProject) o;
        return id == that.id && Objects.equals(studentId, that.studentId) && Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, projectId, id);
    }
}

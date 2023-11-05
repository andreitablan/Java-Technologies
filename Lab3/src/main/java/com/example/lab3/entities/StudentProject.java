package com.example.lab3.entities;

/**
 * StudentProject com.example.lab3.entity
 */
public class StudentProject {
    private int studentId;
    private int projectId;

    public StudentProject(int studentId, int projectId) {
        this.studentId = studentId;
        this.projectId = projectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}

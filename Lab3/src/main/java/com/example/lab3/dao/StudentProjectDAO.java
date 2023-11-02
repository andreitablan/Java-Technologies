package com.example.lab3.dao;

import com.example.lab3.entities.Project;
import com.example.lab3.entities.Student;
import com.example.lab3.infrastructure.DatSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for the student_project table - handles the many-to-many relationship between students and projects
 */
public class StudentProjectDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "razvan08";

    public static List<Project> getProjectsForStudent(Student student) {
        List<Project> projects = new ArrayList<>();
        DatSource datSource = DatSource.getInstance();
        try (Connection connection = datSource.getConnection()) {
            String sql = "SELECT p.id, p.name, p.category, p.description, p.deadline " +
                    "FROM projects p " +
                    "INNER JOIN student_projects sp ON p.id = sp.project_id " +
                    "WHERE sp.student_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, student.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int projectId = resultSet.getInt("id");
                String projectName = resultSet.getString("name");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");
                Date deadline = resultSet.getDate("deadline");

                Project project = new Project(projectId, projectName, category, description, deadline);
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projects;
    }
    public static void updateStudentProjects(Student student, List<Project> projects) {
        DatSource datSource = DatSource.getInstance();
        try (Connection connection = datSource.getConnection()) {
            String deleteSql = "DELETE FROM student_projects WHERE student_id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, student.getId());
            deleteStatement.executeUpdate();

            String insertSql = "INSERT INTO student_projects (student_id, project_id) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);

            for (Project project : projects) {
                insertStatement.setInt(1, student.getId());
                insertStatement.setInt(2, project.getId());
                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package com.example.lab3.dao;

import com.example.lab3.entities.Project;
import com.example.lab3.entities.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentProjectDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "razvan08";

    public static List<Project> getProjectsForStudent(Student student) {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
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

        public static void insertStudentProject(Student student, Project project) {
            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
                String sql = "INSERT INTO student_projects (student_id, project_id) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, student.getId());
                statement.setInt(2, project.getId());

                int affectedRows = statement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating student project failed, no rows affected.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}

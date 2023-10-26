package com.example.lab3.dao;
import com.example.lab3.entities.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for the projects - handles the database operations
 */
public class ProjectDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "razvan08";

    public static List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM projects";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                String description = resultSet.getString("description");
                Date deadline = resultSet.getDate("deadline");

                Project project = new Project(id, name, category, description, deadline);
                projects.add(project);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
    public static void addProject(Project project) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            connection.setAutoCommit(true); // Set auto-commit to true
            String sql = "INSERT INTO projects (name, category, description, deadline) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getCategory());
            statement.setString(3, project.getDescription());
            statement.setDate(4, project.getDeadline());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProject(Project project) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE projects SET name = ?, category = ?, description = ?, deadline = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getCategory());
            statement.setString(3, project.getDescription());
            statement.setDate(4, project.getDeadline());
            statement.setInt(5, project.getId());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteProject(Project project) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String deleteStudentProjectsSql = "DELETE FROM student_projects WHERE project_id = ?";
            PreparedStatement deleteStudentProjectsStatement = connection.prepareStatement(deleteStudentProjectsSql);
            deleteStudentProjectsStatement.setInt(1, project.getId());
            deleteStudentProjectsStatement.executeUpdate();

            String deleteProjectSql = "DELETE FROM projects WHERE id = ?";
            PreparedStatement deleteProjectStatement = connection.prepareStatement(deleteProjectSql);
            deleteProjectStatement.setInt(1, project.getId());
            deleteProjectStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


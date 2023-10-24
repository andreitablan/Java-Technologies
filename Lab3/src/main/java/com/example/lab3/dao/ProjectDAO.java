package com.example.lab3.dao;
import com.example.lab3.entities.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                Date deadline = resultSet.getDate("deadline");

                Project project = new Project(id, name, description, category, deadline);
                projects.add(project);
            }
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


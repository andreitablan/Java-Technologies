package com.example.lab3.infrastructure;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ResourceInjectionExample {
    @Resource(lookup = "java:/PostgresDS")
    private DataSource dataSource;

    public void performDatabaseOperation() {
        try (Connection connection = dataSource.getConnection()) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

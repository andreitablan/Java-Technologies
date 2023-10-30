package com.example.lab3.infrastructure;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Lab 4 compulsory
 */
public class ResourceInjection {
    @Resource(lookup = "java:/PostgresDS")
    private DataSource dataSource;
    public DataSource getDataSource() {
        return dataSource;
    }
    public void performDatabaseOperation() {
        try (Connection connection = dataSource.getConnection()) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

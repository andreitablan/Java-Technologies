package com.example.laboratory5.infrastructure;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatSource {
    private static DatSource instance = null;
    private DataSource dataSource;
    private Connection connection;

    private DatSource() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:/PostgresDS");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatSource getInstance() {
        if (instance == null) {
            instance = new DatSource();
        }
        return instance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
        }
        return connection;
    }
}

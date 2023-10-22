package com.example.lab3;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil {
    private static DataSource dataSource;

    static {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/lab3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package org.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnector {
    private static Connection conn;

    private DatabaseConnector() {
    }

    public static Connection getConnection() throws SQLException {

        if (conn != null && !conn.isClosed()) {
            return conn;
        }

        try {
            String url = System.getenv("FLYWAY_URL");
            String password = System.getenv("FLYWAY_PASSWORD");
            String username = System.getenv("FLYWAY_USER");

            if (username == null || password == null || url == null) {
                throw new IllegalArgumentException(
                        "Add the following properties to env vars: "
                                + "DB_USERNAME, "
                                + "DB_PASSWORD, DB_HOST and DB_NAME");
            }
            conn = DriverManager.getConnection(
                    url + "?useSSL=false", username, password);
            return conn;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}

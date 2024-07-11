package org.example.daos;

import org.example.models.LoginRequest;
import org.example.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthDao {
    public User getUser(LoginRequest loginRequest) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT Username, Password, SystemRoleId FROM `User` where Username = ? AND Password = ?";

            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, loginRequest.getUsername());
            st.setString(2, loginRequest.getPassword());

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("SystemRoleId"));
            }
        }
        return null;
    }

    public void createUser(LoginRequest loginRequest) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO `User` (Username, Password) VALUES (?, ?)";

            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, loginRequest.getUsername());
            st.setString(1, loginRequest.getPassword());

            st.executeUpdate();
        }
    }
}



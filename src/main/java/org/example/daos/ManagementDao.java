package org.example.daos;

import org.example.models.ManagementRequest;
import org.example.models.ProjectClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagementDao {

    @SuppressWarnings("checkstyle:MagicNumber")
    public int createProject(final ManagementRequest project) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement =
                "INSERT INTO Project "
                        +
                        "(project_name, project_value, client_id) "
                        +
                        "VALUES (?,?,?)";

        PreparedStatement st
                =
                c.prepareStatement(insertStatement,
                        Statement.RETURN_GENERATED_KEYS);

        st.setString(1, project.getName());
        st.setDouble(2, project.getValue());
        st.setInt(3, project.getClient_id());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();

        if
        (rs.next()) {
            return rs.getInt(1);
        }
        return -1;

    }

    public List<ProjectClient> getAllClients() throws SQLException {
        List<ProjectClient> projClient = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT client_id, client_name FROM `Client`;");
            while (resultSet.next()) {
                ProjectClient client = new ProjectClient(
                        resultSet.getInt("client_id"),
                        resultSet.getString("client_name")
                );

                projClient.add(client);
            }

        }
        return projClient;
    }
}

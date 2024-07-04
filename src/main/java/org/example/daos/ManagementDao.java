package org.example.daos;

import org.example.models.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManagementDao {

    @SuppressWarnings("checkstyle:MagicNumber")
    public int createProject(final Project project) throws SQLException {
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
        st.setInt(3, project.getClient());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();

        if
        (rs.next()) {
            return rs.getInt(1);
        }
        return -1;

    }
}

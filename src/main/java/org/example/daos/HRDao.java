package org.example.daos;

import org.example.models.HRRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HRDao {
    @SuppressWarnings("checkstyle:MagicNumber")
    public int createDeliveryEmployee(final HRRequest hrRequest)
            throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        String insertStatement = "INSERT INTO Employee(emp_fname,"
                +
                " emp_lname,role_id, bank_acct_no, ni_no, salary) "
                + "VAlUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, hrRequest.getEmpFname());
        ps.setString(2, hrRequest.getEmplname());
        ps.setInt(3, hrRequest.getRoleId());
        ps.setInt(4, hrRequest.getBankAcctNo());
        ps.setString(5, hrRequest.getNationalInsuranceNo());
        ps.setDouble(6, hrRequest.getSalary());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

}

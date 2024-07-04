package org.example.daos;

import org.example.models.Employee;
import org.example.models.HRRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HRDao {

public int createDeliveryEmployee(HRRequest hrRequest) throws SQLException {
    Connection c = DatabaseConnector.getConnection();

    String insertStatement = "INSERT INTO Employee(emp_fname, emp_lname, bank_acct_no, ni_no) VAlUES (?, ?, ?, ?)";

    PreparedStatement ps = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

    ps.setString(1, hrRequest.getEmp_fname());
    ps.setString(2, hrRequest.getEmp_lname());
    ps.setInt(3, hrRequest.getBank_acct_no());
    ps.setString(4, hrRequest.getNi_no());

    ps.executeUpdate();

    ResultSet rs = ps.getGeneratedKeys();

    if (rs.next()) {
        return rs.getInt(1);
    }
    return -1;
}

}

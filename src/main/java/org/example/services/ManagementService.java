package org.example.services;

import org.example.daos.DatabaseConnector;
import org.example.daos.ManagementDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.ManagementRequest;
import org.example.models.Project;
import org.example.models.ProjectClient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManagementService {

    ManagementDao managementDao;

    public ManagementService(final ManagementDao managementDao) {
        this.managementDao = managementDao;
    }

    public int createProject(ManagementRequest managementRequest)
            throws FailedToCreateException, SQLException {
        int id = managementDao.createProject(managementRequest);

        if
        (id == -1) {
            throw new FailedToCreateException(Entity.MANAGEMENT);
        }

        return id;
    }

    public List<ProjectClient> getAllProjectClients() throws SQLException{
        return managementDao.getAllClients();
    }
}



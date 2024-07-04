package org.example.services;

import org.example.daos.ManagementDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.Project;

import java.sql.SQLException;

public class ManagementService {

    ManagementDao managementDao;

    public ManagementService(final ManagementDao managementDao) {
        this.managementDao = managementDao;
    }

    public int createProject(final Project project)
            throws FailedToCreateException, SQLException {
        int id = managementDao.createProject(project);

        if
        (id == -1) {
            throw new FailedToCreateException(Entity.MANAGEMENT);
        }

        return id;
    }
}

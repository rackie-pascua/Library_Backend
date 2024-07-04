package org.example.services;


import org.example.daos.HRDao;
import org.example.exceptions.Entity;
import org.example.exceptions.FailedToCreateException;
import org.example.models.HRRequest;

import java.sql.SQLException;

public class HRService {

    HRDao hrDao;

    public HRService(final HRDao hrDao) {
        this.hrDao = hrDao;
    }

    public int createDeliveryEmployee(final HRRequest hrRequest)
            throws SQLException, FailedToCreateException {
        int id = hrDao.createDeliveryEmployee(hrRequest);

        if (id == -1) {
            throw new FailedToCreateException(Entity.HR);
        }
        return id;
    }
}

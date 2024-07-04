package org.example.services;


import org.example.daos.HRDao;
import org.example.models.HRRequest;

import java.sql.SQLException;

public class HRService {

    HRDao hrDao;

    public HRService(HRDao HrDao) {
        this.hrDao = HrDao;
    }

    public int createDeliveryEmployee(HRRequest hrRequest) throws SQLException {
    int id = hrDao.createDeliveryEmployee(hrRequest);

    if (id == -1) {
    }
    return id;
}

}

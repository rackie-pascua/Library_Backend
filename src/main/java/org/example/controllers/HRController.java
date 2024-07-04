package org.example.controllers;


import io.swagger.annotations.Api;
import org.example.models.HRRequest;
import org.example.services.HRService;
import org.example.services.TestService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("HR API")
@Path("/api/HR")
public class HRController {

    HRService hrService;

    public HRController(HRService hrService) { this.hrService = hrService;
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(HRRequest hrRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(hrService.createDeliveryEmployee(hrRequest))
                    .build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}
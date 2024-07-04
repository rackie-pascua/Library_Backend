package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.models.HRRequest;
import org.example.services.HRService;

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

    public HRController(final HRService hrService) {
        this.hrService = hrService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(final HRRequest hrRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(hrService.createDeliveryEmployee(hrRequest))
                    .build();
        } catch (SQLException e) {

            return Response.serverError().entity(e.getMessage()).build();
        } catch (FailedToCreateException e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }
    }
}

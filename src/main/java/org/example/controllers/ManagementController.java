package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.models.Project;
import org.example.services.ManagementService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Management API")
@Path("/api/management")
public class ManagementController {
    final ManagementService managementService;

    public ManagementController(final ManagementService managementService) {
        this.managementService = managementService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManagement() {
        return Response.ok().entity("List of management").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(final Project project) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(managementService.createProject(project))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (
                FailedToCreateException e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }
    }
}

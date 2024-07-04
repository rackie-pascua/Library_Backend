package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.services.ManagementService;
import org.example.services.TestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Management API")
@Path("/api/management")
public class ManagementController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getManagement() {
        return Response.ok().entity("List of management").build();
    }
}
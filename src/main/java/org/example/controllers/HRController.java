package org.example.controllers;


import io.swagger.annotations.Api;
import org.example.services.HRService;
import org.example.services.TestService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("HR API")
@Path("/api/HR")
public class HRController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHR() {
        return Response.ok().entity("HR Management API").build();
    }
}


package ch.zli.m223.controller;

import ch.zli.m223.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthController {

    @Inject
    AuthService authService;

    @GET
    @Path("/token")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getToken() {
        return authService.generateToken();
    }
}

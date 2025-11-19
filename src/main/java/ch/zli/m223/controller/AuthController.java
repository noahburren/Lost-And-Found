package ch.zli.m223.controller;

import ch.zli.m223.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    public String login(LoginRequest req) {
        return authService.login(req.email, req.password)
                .getEntity()
                .toString();
    }

    public static class LoginRequest {
        public String email;
        public String password;
    }
}

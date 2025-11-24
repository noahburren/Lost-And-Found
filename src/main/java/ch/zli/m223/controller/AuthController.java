package ch.zli.m223.controller;

import ch.zli.m223.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthController {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    public Response login(LoginRequest req) {
        return authService.login(req.email, req.password);
    }

    // CORS Preflight Handler
    @OPTIONS
    @Path("/login")
    public Response preflight() {
        return Response.ok().build();
    }

    public static class LoginRequest {
        public String email;
        public String password;
    }
}

package ch.zli.m223.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.UserModel;
import ch.zli.m223.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    UserService service;

    @GET
    @RolesAllowed("Admin")
    @Operation(summary = "Index all Users.", description = "Returns a list of all Users.")
    public List<UserModel> getAll() {
        return service.getAll();
    }

    @POST
    public UserModel create(UserModel user) {
        return service.create(user);
    }
}

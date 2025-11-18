package ch.zli.m223.controller;

import java.util.List;

import ch.zli.m223.model.UserModel;
import ch.zli.m223.service.UserService;
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
    public List<UserModel> getAll() {
        return service.getAll();
    }

    @POST
    public UserModel create(UserModel user) {
        return service.create(user);
    }
}

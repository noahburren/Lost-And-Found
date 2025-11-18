package ch.zli.m223.controller;

import ch.zli.m223.model.UserModel;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @GET
    public List<UserModel> getAll() {
        return UserModel.listAll();
    }

    @POST
    @Transactional
    public UserModel create(UserModel user) {
        user.persist();
        return user;
    }
}

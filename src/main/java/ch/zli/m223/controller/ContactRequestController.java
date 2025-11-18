package ch.zli.m223.controller;

import ch.zli.m223.model.ContactRequestModel;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/contact-requests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactRequestController {

    @GET
    public List<ContactRequestModel> getAll() {
        return ContactRequestModel.listAll();
    }

    @POST
    @Transactional
    public ContactRequestModel create(ContactRequestModel request) {
        request.persist();
        return request;
    }
}

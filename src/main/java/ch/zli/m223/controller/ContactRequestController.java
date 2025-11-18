package ch.zli.m223.controller;

import ch.zli.m223.model.ContactRequestModel;
import ch.zli.m223.service.ContactRequestService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/contact-requests")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactRequestController {

    @Inject
    ContactRequestService service;

    @GET
    public List<ContactRequestModel> getAll() {
        return service.getAll();
    }

    @POST
    public ContactRequestModel create(ContactRequestModel request) {
        return service.create(request);
    }
}

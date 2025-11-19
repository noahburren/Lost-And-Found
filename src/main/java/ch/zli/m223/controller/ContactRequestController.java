package ch.zli.m223.controller;

import ch.zli.m223.model.ContactRequestModel;
import ch.zli.m223.service.ContactRequestService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/contact-requests")
@RolesAllowed({ "User", "Admin" })
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactRequestController {

    @Inject
    ContactRequestService service;

    @GET
    @Operation(summary = "Index all Contact Requests.", description = "Returns a list of all Contact Requests.")
    public List<ContactRequestModel> getAll() {
        return service.getAll();
    }

    @POST
    public ContactRequestModel create(ContactRequestModel request) {
        return service.create(request);
    }
}

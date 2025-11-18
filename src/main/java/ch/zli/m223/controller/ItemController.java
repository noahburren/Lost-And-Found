package ch.zli.m223.controller;

import ch.zli.m223.model.ItemModel;
import ch.zli.m223.service.ItemService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {

    @Inject
    ItemService service;

    @GET
    @Operation(summary = "Index all Items.", description = "Returns a list of all Items.")
    public List<ItemModel> getAll() {
        return service.getAll();
    }

    @POST
    public ItemModel create(ItemModel item) {
        return service.create(item);
    }
}

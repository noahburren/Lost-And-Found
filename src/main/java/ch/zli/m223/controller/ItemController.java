package ch.zli.m223.controller;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import ch.zli.m223.model.ItemModel;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {

    @GET
    public List<ItemModel> getAll() {
        return ItemModel.listAll();
    }

    @POST
    @Transactional
    public ItemModel create(ItemModel item) {
        item.persist();
        return item;
    }
}

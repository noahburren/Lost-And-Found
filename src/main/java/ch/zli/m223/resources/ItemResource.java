package ch.zli.m223.resources;

import ch.zli.m223.entities.Item;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

    @GET
    public List<Item> getAll() {
        return Item.listAll();
    }

    @POST
    @Transactional
    public Item create(Item item) {
        item.persist();
        return item;
    }
}

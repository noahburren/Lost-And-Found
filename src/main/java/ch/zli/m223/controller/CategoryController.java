package ch.zli.m223.controller;

import ch.zli.m223.model.CategoryModel;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {

    @GET
    public List<CategoryModel> getAll() {
        return CategoryModel.listAll();
    }

    @POST
    @Transactional
    public CategoryModel create(CategoryModel category) {
        category.persist();
        return category;
    }
}

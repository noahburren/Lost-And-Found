package ch.zli.m223.controller;

import ch.zli.m223.model.CategoryModel;
import ch.zli.m223.service.CategoryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GET
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    @POST
    public CategoryModel create(CategoryModel category) {
        return categoryService.create(category);
    }
}

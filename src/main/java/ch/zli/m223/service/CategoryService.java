package ch.zli.m223.service;

import ch.zli.m223.model.CategoryModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CategoryService {

    @Inject
    EntityManager em;

    public List<CategoryModel> getAll() {
        return CategoryModel.listAll();
    }

    @Transactional
    public CategoryModel create(CategoryModel category) {
        em.persist(category);
        return category;
    }
}

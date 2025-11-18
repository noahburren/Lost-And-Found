package ch.zli.m223.service;

import ch.zli.m223.model.ItemModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ItemService {

    @Inject
    EntityManager em;

    public List<ItemModel> getAll() {
        return ItemModel.listAll();
    }

    @Transactional
    public ItemModel create(ItemModel item) {
        em.persist(item);
        return item;
    }
}

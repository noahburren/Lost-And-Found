package ch.zli.m223.service;

import ch.zli.m223.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager em;

    public List<UserModel> getAll() {
        return UserModel.listAll();
    }

    @Transactional
    public UserModel create(UserModel user) {
        em.persist(user);
        return user;
    }
}

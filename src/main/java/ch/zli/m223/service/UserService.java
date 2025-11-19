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
    public UserModel signup(UserModel user) {

        // Passwort hashen
        String hashed = org.mindrot.jbcrypt.BCrypt.hashpw(user.password, org.mindrot.jbcrypt.BCrypt.gensalt());
        user.password = hashed;

        // Rolle bestimmen
        if ("Noah Burren".equalsIgnoreCase(user.name.trim())) {
            user.role = "Admin";
        } else {
            user.role = "User";
        }

        em.persist(user);
        return user;
    }

    public UserModel findByEmail(String email) {
        return UserModel.find("email", email).firstResult();
    }
}

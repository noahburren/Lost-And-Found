package ch.zli.m223.data;

import ch.zli.m223.model.CategoryModel;
import ch.zli.m223.model.ContactRequestModel;
import ch.zli.m223.model.ItemModel;
import ch.zli.m223.model.UserModel;
import io.quarkus.runtime.Startup;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@ApplicationScoped
public class DatabaseSeeder {

        @Inject
        EntityManager em;

        @Startup
        @Transactional
        public void seed() {
                // === USERS ===
                UserModel u1 = new UserModel("Noah Burren", "noah@example.com");
                UserModel u2 = new UserModel("Levi Fuchs", "levi@example.com");
                UserModel u3 = new UserModel("Random Dude", "random@example.com");

                em.persist(u1);
                em.persist(u2);
                em.persist(u3);

                // === CATEGORIES ===
                CategoryModel c1 = new CategoryModel("Elektronik");
                CategoryModel c2 = new CategoryModel("Kleidung");
                CategoryModel c3 = new CategoryModel("Dokumente");
                CategoryModel c4 = new CategoryModel("Sonstiges");

                em.persist(c1);
                em.persist(c2);
                em.persist(c3);
                em.persist(c4);

                // === ITEMS ===
                ItemModel i1 = new ItemModel("iPhone 14 Pro", "Schwarzes iPhone ohne Hülle", "lost", "Zürich HB",
                                LocalDate.parse("2025-11-10"), c1);
                ItemModel i2 = new ItemModel("Portemonnaie", "Braunes Leder, enthält ID", "lost", "Oerlikon",
                                LocalDate.parse("2025-11-11"), c3);
                ItemModel i3 = new ItemModel("Jacke", "Schwarze Winterjacke", "found", "Glattzentrum",
                                LocalDate.parse("2025-11-09"), c2);
                ItemModel i4 = new ItemModel("Kopfhörer", "Weiße AirPods", "found", "Bellevue",
                                LocalDate.parse("2025-11-08"),
                                c1);

                em.persist(i1);
                em.persist(i2);
                em.persist(i3);
                em.persist(i4);

                // === CONTACT REQUESTS ===
                em.persist(new ContactRequestModel("Gehört mir!", u1, i3));
                em.persist(new ContactRequestModel("Ich glaube, das ist mein iPhone", u2, i1));
                em.persist(new ContactRequestModel("Ist das noch verfügbar?", u3, i4));
        }
}

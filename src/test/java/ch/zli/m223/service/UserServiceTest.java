package ch.zli.m223.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import ch.zli.m223.model.UserModel;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    void signup_shouldCreateAdminForNoah() {
        UserService service = new UserService();
        service.em = mock(EntityManager.class);

        UserModel u = new UserModel();
        u.name = "Noah Burren";
        u.email = "noah@example.com";
        u.password = "1234";

        UserModel created = service.signup(u);

        assertEquals("Admin", created.role);
    }

    @Test
    void signup_shouldHashPassword() {
        UserService service = new UserService();
        service.em = mock(EntityManager.class);

        UserModel u = new UserModel();
        u.name = "Test User";
        u.email = "test@example.com";
        u.password = "1234";

        UserModel created = service.signup(u);

        assertNotEquals("1234", created.password);
        assertTrue(created.password.startsWith("$2"));
    }
}

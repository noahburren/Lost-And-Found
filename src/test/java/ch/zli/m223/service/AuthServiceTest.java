package ch.zli.m223.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import ch.zli.m223.model.UserModel;


public class AuthServiceTest {

    @Test
    void login_shouldFailForInvalidPassword() {
        AuthService auth = new AuthService();
        UserService mockUserService = mock(UserService.class);
        auth.userService = mockUserService;

        UserModel u = new UserModel("Test", "test@example.com",
                BCrypt.hashpw("1234", BCrypt.gensalt()), "User");

        when(mockUserService.findByEmail("test@example.com")).thenReturn(u);

        Response r = auth.login("test@example.com", "WRONG");

        assertEquals(401, r.getStatus());
        assertEquals("Invalid password", r.getEntity());
    }
}

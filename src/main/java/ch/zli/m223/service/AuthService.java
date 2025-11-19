package ch.zli.m223.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import ch.zli.m223.model.UserModel;

@ApplicationScoped
public class AuthService {

    @Inject
    UserService userService;

    public Response login(String email, String password) {
        UserModel user = userService.findByEmail(email);

        if (user == null) {
            return Response.status(401).entity("User not found").build();
        }

        boolean pwValid = org.mindrot.jbcrypt.BCrypt.checkpw(password, user.password);
        if (!pwValid) {
            return Response.status(401).entity("Invalid password").build();
        }

        String token = Jwt.upn(user.email)
                .issuer("https://example.com/issuer")
                .groups(user.role) // Admin oder User
                .sign();

        return Response.ok(token).build();
    }
}

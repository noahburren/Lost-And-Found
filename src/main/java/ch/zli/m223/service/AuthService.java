package ch.zli.m223.service;

import ch.zli.m223.model.UserModel;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class AuthService {

    @Inject
    UserService userService;

    public Response login(String email, String password) {

        UserModel user = userService.findByEmail(email);

        if (user == null) {
            return Response.status(401).entity("User not found").build();
        }

        boolean validPw = BCrypt.checkpw(password, user.password);

        if (!validPw) {
            return Response.status(401).entity("Invalid password").build();
        }

        String token = Jwt.upn(user.email)
                .issuer("https://example.com/issuer")
                .groups(user.role)
                .sign();

        return Response.ok(token).build();
    }
}

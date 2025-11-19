package ch.zli.m223.integration;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class AuthLoginIT {

    @Test
    void givenValidCredentials_whenLogin_thenTokenReturned() {
        String loginBody = """
                {
                    "email": "noah@example.com",
                    "password": "1234"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(loginBody)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }
}

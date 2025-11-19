package ch.zli.m223.integration;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class UserSignupIT {

    @Test
    void givenValidUser_whenSignup_thenUserIsPersisted() {
        // GIVEN
        String body = """
                {
                    "name": "Test User",
                    "email": "test@example.com",
                    "password": "1234"
                }
                """;

        // WHEN & THEN
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users/signup")
                .then()
                .statusCode(200)
                .body("email", equalTo("test@example.com"))
                .body("password", not("1234"))
                .body("role", equalTo("User"));
    }
}

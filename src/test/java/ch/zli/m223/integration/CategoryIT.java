package ch.zli.m223.integration;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestSecurity(user = "Noah Burren", roles = "Admin")
public class CategoryIT {

    @Test
    void givenNewCategory_whenCreate_thenCategoryExists() {
        String body = """
                {
                    "name": "TestKategorie"
                }
                """;

        // POST /categories
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/categories")
                .then()
                .statusCode(200)
                .body("name", equalTo("TestKategorie"));

        // GET /categories → prüfen ob drin
        when()
                .get("/categories")
                .then()
                .statusCode(200)
                .body("name", hasItem("TestKategorie"));
    }
}

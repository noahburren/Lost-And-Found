package ch.zli.m223.e2e;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ItemWorkflowE2EIT {

    @Test
    void fullItemCreationWorkflow() {

        // GIVEN
        String itemJson = """
                {
                    "title": "Goldener AirTag",
                    "description": "Gefunden am HB",
                    "type": "lost",
                    "location": "Zürich HB",
                    "date": "2025-11-20",
                    "category": { "id": 1 }
                }
                """;

        // WHEN: Item erstellen
        given()
                .contentType(ContentType.JSON)
                .body(itemJson)
                .when()
                .post("/items")
                .then()
                .statusCode(200)
                .body("title", equalTo("Goldener AirTag"));

        // THEN: Item existiert in der Liste
        when()
                .get("/items")
                .then()
                .statusCode(200)
                .body("title", hasItem("Goldener AirTag"));
    }
}

package ch.zli.m223.integration;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ItemIT {

    @Test
    void givenValidItem_whenCreate_thenItemIsPersisted() {

        // zuerst eine Kategorie anlegen (sonst kein FK)
        String categoryJson = """
                { "name": "IT-TestCategory" }
                """;

        int categoryId = given()
                .contentType(ContentType.JSON)
                .body(categoryJson)
                .when()
                .post("/categories")
                .then()
                .statusCode(200)
                .extract()
                .path("id");

        // jetzt Item erstellen
        String itemJson = """
                {
                    "title": "Integrationstest-Item",
                    "description": "Testbeschreibung",
                    "type": "lost",
                    "location": "Testplatz",
                    "date": "2025-11-20",
                    "category": { "id": %d }
                }
                """.formatted(categoryId);

        given()
                .contentType(ContentType.JSON)
                .body(itemJson)
                .when()
                .post("/items")
                .then()
                .statusCode(200)
                .body("title", equalTo("Integrationstest-Item"));

        // prüfen ob es existiert
        when()
                .get("/items")
                .then()
                .statusCode(200)
                .body("title", hasItem("Integrationstest-Item"));
    }
}

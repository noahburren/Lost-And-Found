package ch.zli.m223.service;

import ch.zli.m223.model.CategoryModel;
import ch.zli.m223.model.ItemModel;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ItemServiceTransactionalIT {

    @Test
    @TestTransaction // <-- GANZ WICHTIG: alles wird nach Test ROLLBACKED
    void createItem_shouldNotPersistAfterTest() {

        // GIVEN
        CategoryModel c = new CategoryModel("Transaktion-Test");
        c.persist();

        ItemModel item = new ItemModel(
                "TestItem",
                "Beschreibung",
                "lost",
                "HB",
                LocalDate.now(),
                c);

        // WHEN
        item.persist();

        // THEN
        assertNotNull(item.id);
        assertTrue(ItemModel.listAll().size() > 0,
                "Item müsste in der Test-Transaktion sichtbar sein");

        // Nach dem Test rollt Quarkus alles automatisch zurück
    }

    @Test
    void databaseShouldBeEmpty_AfterRollback() {

        // kein @TestTransaction → neue Transaktion
        // Ergebnis: DB ist wieder CLEAN

        assertEquals(6, ItemModel.listAll().size(),
                "DB sollte nach dem Rollback vom vorherigen Test wieder normal sein");
    }
}

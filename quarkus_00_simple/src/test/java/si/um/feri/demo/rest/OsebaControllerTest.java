package si.um.feri.demo.rest;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import si.um.feri.demo.dto.OsebaDto;

import java.util.List;

@QuarkusTest
public class OsebaControllerTest {

    @Inject
    OsebaController osebaController;

    @Test
    @TestTransaction
    public void testCreateReadUpdateDeleteOseba() {
        // Create a new Oseba
        OsebaDto newOseba = new OsebaDto(null, "Test", "Testni", 30);
        Response postResponse = osebaController.postOseba(newOseba);
        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), postResponse.getStatus());
        OsebaDto createdOseba = (OsebaDto) postResponse.getEntity();

        // Read the created Oseba
        Response getResponse = osebaController.getOsebaById(createdOseba.id().intValue());
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), getResponse.getStatus());
        OsebaDto fetchedOseba = (OsebaDto) getResponse.getEntity();
        Assertions.assertEquals(newOseba.ime(), fetchedOseba.ime());

        // Update the Oseba
        OsebaDto updatedOseba = new OsebaDto(createdOseba.id(), "Updated", "Updatedni", 35);
        Response putResponse = osebaController.putOseba(createdOseba.id().intValue(), updatedOseba);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), putResponse.getStatus());

        // Validate the update
        Response updatedGetResponse = osebaController.getOsebaById(createdOseba.id().intValue());
        OsebaDto fetchedUpdatedOseba = (OsebaDto) updatedGetResponse.getEntity();
        Assertions.assertEquals("Updated", fetchedUpdatedOseba.ime());

        // Delete the Oseba
        Response deleteResponse = osebaController.deleteOseba(createdOseba.id().intValue());
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), deleteResponse.getStatus());

        // Validate the deletion
        Response deletedGetResponse = osebaController.getOsebaById(createdOseba.id().intValue());
        Assertions.assertEquals(Response.Status.NOT_FOUND.getStatusCode(), deletedGetResponse.getStatus());
    }

    @Test
    @TestTransaction
    public void testVseOsebe() {
        // Create a couple of Oseba entities
        osebaController.postOseba(new OsebaDto(null, "Test1", "Testni1", 25));
        osebaController.postOseba(new OsebaDto(null, "Test2", "Testni2", 30));

        // Retrieve all Oseba entities
        List<OsebaDto> osebe = osebaController.vseOsebe();

        // Assertions
        Assertions.assertNotNull(osebe);
        Assertions.assertTrue(osebe.size() >= 2);
    }

}
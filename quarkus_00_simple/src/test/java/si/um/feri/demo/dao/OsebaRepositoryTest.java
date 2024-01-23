package si.um.feri.demo.dao;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import si.um.feri.demo.vao.Oseba;

import static io.smallrye.common.constraint.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class OsebaRepositoryTest {

    @Inject
    OsebaRepository osebaRepository;

    private Oseba oseba;

    @BeforeEach
    @Transactional
    void beforeEach() {
        osebaRepository.deleteAll();
        oseba = new Oseba();
        oseba.setIme("Bine");
        oseba.setPriimek("Yulovski");
        oseba.setStarost(27);
        osebaRepository.persist(oseba);
    }

    @Test
    @Transactional
    void addAnotherOsebaTest() {
        assertEquals(1, osebaRepository.count());
        assertEquals("Bine", oseba.getIme());
        assertEquals("Yulovski", oseba.getPriimek());
        assertEquals(27, oseba.getStarost());

        Oseba o = new Oseba();
        o.setIme("Yule");
        osebaRepository.persist(o);

        assertEquals(2, osebaRepository.count());

        Oseba foundOseba = osebaRepository.findById(o.getId());
        assertNotNull(foundOseba);
        assertEquals("Yule", foundOseba.getIme());
        assertEquals(null, foundOseba.getPriimek());
        assertEquals(0, foundOseba.getStarost());
    }

    @Test
    @Transactional
    void deleteOsebaTest() {
        assertEquals(1, osebaRepository.count());
        osebaRepository.deleteById(oseba.getId());
        assertEquals(0, osebaRepository.count());
    }

}
package si.um.feri.demo;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import si.um.feri.demo.dao.OsebaRepository;
import si.um.feri.demo.vao.Oseba;

import java.util.logging.Logger;

@ApplicationScoped
public class DemoApplicationLifecycle {

    private static final Logger log = Logger.getLogger(DemoApplicationLifecycle.class.getName());

    @Inject
    OsebaRepository osebaRepository;

    void onStart(@Observes StartupEvent ev) {
        log.info("The application is starting...");
        populateTestDataIfNotPresent();
    }

    @Transactional
    void populateTestDataIfNotPresent() {
        if (osebaRepository.count() > 0) {
            log.info("populateTestData - skipped.");
            return;
        }
        log.info("populateTestData initiated.");

        Oseba o1 = new Oseba();
        o1.setIme("Bine");
        o1.setPriimek("Yulovski");
        o1.setStarost(27);
        osebaRepository.persist(o1);

        Oseba o2 = new Oseba();
        o2.setIme("Yule");
        o2.setPriimek("Binovski");
        o2.setStarost(28);
        osebaRepository.persist(o2);
    }
}
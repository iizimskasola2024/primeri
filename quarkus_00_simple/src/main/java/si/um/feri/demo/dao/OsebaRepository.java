package si.um.feri.demo.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import si.um.feri.demo.vao.Oseba;

@ApplicationScoped
public class OsebaRepository implements PanacheRepository<Oseba> {

}
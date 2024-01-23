package si.um.feri.demo.rest;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import si.um.feri.demo.dao.OsebaRepository;
import si.um.feri.demo.dto.OsebaDto;
import si.um.feri.demo.vao.Oseba;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("/osebe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OsebaController {

    private static final Logger log = Logger.getLogger(OsebaController.class.getName());

    @Inject
    OsebaRepository osebaRepository;

    @GET
    public List<OsebaDto> vseOsebe() {
        return osebaRepository.listAll()
                .stream()
                .map(Oseba::toDto)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public Response getOsebaById(@PathParam("id") int id) {
        Oseba oseba = osebaRepository.findById((long) id);
        if (oseba == null) {
            log.info(() -> "/osebe/" + id + " ; Oseba ni najdena!");
            return Response.status(Response.Status.NOT_FOUND).entity("Oseba ni najden").build();
        }
        return Response.ok(oseba.toDto()).build();
    }

    @POST
    @Transactional
    public Response postOseba(OsebaDto dto) {
        Oseba oseba = new Oseba(dto);
        osebaRepository.persist(oseba);
        return Response.ok(oseba.toDto()).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response putOseba(@PathParam("id") int id, OsebaDto dto) {
        Oseba oseba = osebaRepository.findById((long) id);
        if (oseba == null) {
            log.info(() -> "/osebe/" + id + " ; Oseba ni najdena!");
            return Response.status(Response.Status.NOT_FOUND).entity("Oseba ni najdena").build();
        }
        oseba.updateFrom(dto);
        osebaRepository.persist(oseba);
        return Response.ok(oseba.toDto()).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteOseba(@PathParam("id") int id) {
        Oseba oseba = osebaRepository.findById((long) id);
        if (oseba == null) {
            log.info(() -> "/osebe/" + id + " ; Oseba ni najdena!");
            return Response.status(Response.Status.NOT_FOUND).entity("Oseba ni najdena").build();
        }
        osebaRepository.delete(oseba);
        return Response.ok("Oseba izbrisana").build();
    }

}
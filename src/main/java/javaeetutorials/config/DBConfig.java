package javaeetutorials.config;

import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/config")
public class DBConfig {

  @PersistenceContext
  private EntityManager entityManager;

  @GET
  @Path("/db")
  public Response showDataBases() {
    List<?> showDatabases = entityManager.createNativeQuery("SHOW DATABASES").getResultList();
    return Response.ok().entity(showDatabases.toString()).build();
  }

  @Produces
  public EntityManager createEntityManager() {
    return entityManager;
  }
}
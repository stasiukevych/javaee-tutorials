package javaeetutorials.jaxrs.clientApi;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("client")
public class ClientApi {

  @GET
  public Response pingByApi() {
    return ClientBuilder.newClient()
                        .target("http://127.0.0.1:8080/javaee-tutorials-1.0/api/cdi/ping")
                        .request(MediaType.APPLICATION_JSON)
                        .get();
  }
}
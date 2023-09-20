package javaeetutorials.ejb.singelton;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("cacheCopy")
public class CacheControllerCopy {

  @EJB
  private Cache cacheStorage;

  @GET
  @Path("put/{key}/{value}")
  public Response putValue(@PathParam("key") String key, @PathParam("value") String value)
      throws InterruptedException {
    cacheStorage.putValue(key, value);
    return Response.ok(cacheStorage.getProp().toString()).build();
  }

  @GET
  @Path("get/{key}")
  public Object getValueByKey(@PathParam("key") String key) {
    return Response.ok("Cache by key[" + key + "] :" + cacheStorage.getValueByKey(key)).build();
  }

  @GET
  @Path("contains/{key}")
  public Response contains(String key) {
    return Response.ok("Cache by key[" + key + "] is present :" + cacheStorage.contains(key))
                   .build();
  }
}
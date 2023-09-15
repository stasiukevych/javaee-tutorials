package javaeetutorials.cdi;

import jakarta.inject.Inject;
import jakarta.interceptor.ExcludeClassInterceptors;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;
import javaeetutorials.cdi.decorator.Formatter;
import javaeetutorials.cdi.events.Laptop;
import javaeetutorials.cdi.events.LaptopService;
import javaeetutorials.cdi.injectionPoint.LoggerTwo;
import javaeetutorials.cdi.interceptorBinding.Loggable;
import javaeetutorials.cdi.producer.CustomFormat;
import javaeetutorials.cdi.producer.Greeting;
import javaeetutorials.cdi.targetClassInterceptor.CreateItem;


@Path("cdi")
@Loggable
public class CdiChecks {

  @Inject
  @CustomFormat
  private String customFormat;

  @Inject
  @Greeting
  private String greeting;

  @Inject
  private LoggerTwo log;

  @Inject
  private CreateItem createItem;

  @Inject
  private Formatter toCustom;

  @Inject
  private LaptopService laptopService;

  @GET
  @Path("/ping")
  public Response ping() {
    return Response.ok().entity(
        greeting + new SimpleDateFormat(customFormat).format(new Date()) + " log: "
            + log.printPlace()
    ).build();
  }

  @GET
  @Path("/create")
  @ExcludeClassInterceptors
  public Response create() {
    return Response.ok().entity(createItem.createItems()).build();
  }

  @GET
  @Path("/toCustom")
  public Response toCustom() {
    return Response.ok().entity(toCustom.formatDate(new Date())).build();
  }

  @GET
  @Path("/add")
  public Response addLaptop(@QueryParam("name") String name,
      @QueryParam("version") String version) {
    return Response.ok().entity(laptopService.create(name, version).toString()).build();
  }

  @GET
  @Path("/remove")
  public Response removeLaptop(@QueryParam("name") String name,
      @QueryParam("version") String version) {
    Laptop laptop = new Laptop();
    laptop.name = name;
    laptop.version = version;
    return Response.ok().entity(laptopService.remove(laptop).toString()).build();
  }
}
package javaeetutorials.jaxrs.extractingParameters;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;

@Path("defaultValues")
public class DefaultValuesController {

  @GET
  public Response ping(
      @QueryParam("name") @DefaultValue("admin") String name,
      @QueryParam("age") @DefaultValue("24") Integer age,
      @QueryParam("phone") @DefaultValue("00000000") String phone,
      @QueryParam("price") @DefaultValue("0.25") BigDecimal price) {

    return Response
        .ok("name: " + name + ", age: " + age + ", phone: " + phone + ", price: " + price).build();
  }
}
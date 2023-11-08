package javaeetutorials.jaxrs.providers;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.logging.Logger;

@Path("phone")
public class PhoneController {

  @Inject
  private Logger logger;

  @GET
  @Produces("phone/type")
  public Phone getAvailablePhone() {
    Phone phone = new Phone();

    phone.setType("new");
    phone.setOwner("I");
    phone.setSerial("1");

    return phone;
  }

  @POST
  @Produces("phone/type")
  @Consumes("phone/type")
  public Phone saveNewPhone(Phone phone) {
    logger.info("was saved: " + phone);
    return phone;
  }
}
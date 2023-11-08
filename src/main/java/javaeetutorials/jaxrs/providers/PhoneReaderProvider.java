package javaeetutorials.jaxrs.providers;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

@Provider
@Consumes("phone/type")
public class PhoneReaderProvider implements MessageBodyReader<Phone> {

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return Phone.class.isAssignableFrom(type);
  }

  @Override
  public Phone readFrom(Class<Phone> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
      throws IOException, WebApplicationException {

    String str = new String(entityStream.readAllBytes(), StandardCharsets.UTF_8);
    StringTokenizer s = new StringTokenizer(str, "/");
    Phone phone = new Phone();
    phone.setType(s.nextToken());
    phone.setOwner(s.nextToken());
    phone.setSerial(s.nextToken());
    return phone;
  }
}
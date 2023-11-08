package javaeetutorials.jaxrs.providers;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces("phone/type")
public class PhoneWriterProvider implements MessageBodyWriter<Phone> {

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return Phone.class.isAssignableFrom(type);
  }

  @Override
  public long getSize(Phone phone, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return phone.getType().length() + 1 + phone.getOwner().length() + 1 + phone.getSerial()
                                                                               .length();
  }

  @Override
  public void writeTo(Phone phone, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
      throws IOException, WebApplicationException {

    entityStream.write(phone.getType().getBytes());
    entityStream.write("/".getBytes());
    entityStream.write(phone.getOwner().getBytes());
    entityStream.write("/".getBytes());
    entityStream.write(phone.getSerial().getBytes());
  }
}
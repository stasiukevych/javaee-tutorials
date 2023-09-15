package javaeetutorials.cdi.producer;

import jakarta.enterprise.inject.Produces;

public class FormatProducer {

  @Produces
  @Greeting
  private final String greeting = "Hello from Producing: ";

  @Produces
  @CustomFormat
  private String customFormat() {
    return "MM-dd-yyyy hh:mm:ss";
  }
}
package javaeetutorials.cdi.producer;

import jakarta.enterprise.inject.Produces;

import java.util.logging.Logger;

public class FormatProducer {

    @Produces
    @Greeting
    private String greeting = "Hello from Producing: ";

    @Produces
    @CustomFormat
    private String customFormat() {
        return "MM-dd-yyyy hh:mm:ss";
    }
}
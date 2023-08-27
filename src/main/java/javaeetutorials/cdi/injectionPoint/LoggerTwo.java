package javaeetutorials.cdi.injectionPoint;

import jakarta.inject.Inject;

import java.util.logging.Logger;

public class LoggerTwo implements Log {

    @Inject
    private Logger logger;

    @Override
    public String printPlace() {
        return logger.getName();
    }
}
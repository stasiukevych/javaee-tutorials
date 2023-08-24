package javaeetutorials.cdi.decorator;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;

import java.text.SimpleDateFormat;
import java.util.Date;

@Decorator
public class FromSimpleToCustomFormat implements Formatter {

    @Inject
    @Delegate
    private Formatter formatter;

    @Override
    public String formatDate(Date date) {
        String simpleFormat = formatter.formatDate(date);
        return simpleFormat + " to " + new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(date);
    }
}
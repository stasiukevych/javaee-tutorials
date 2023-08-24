package javaeetutorials.cdi.decorator;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatterImpl implements Formatter {

    @Override
    public String formatDate(Date date) {
        return DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("en", "US")).format(date);
    }
}
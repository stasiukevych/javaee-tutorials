package javaeetutorials.cdi.qualifier;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@SimpleFormat
public class SimpleFormatService implements Formatter {

  @Override
  public String formatDate(Date date) {
    return DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("en", "US")).format(date);
  }
}
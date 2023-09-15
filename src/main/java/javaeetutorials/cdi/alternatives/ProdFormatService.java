package javaeetutorials.cdi.alternatives;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class ProdFormatService implements Formatter {

  @Override
  public String formatDate(Date date) {
    return DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("en", "US")).format(date);
  }
}
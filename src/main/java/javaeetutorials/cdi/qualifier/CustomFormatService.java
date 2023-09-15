package javaeetutorials.cdi.qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;

@CustomFormat
public class CustomFormatService implements Formatter {

  @Override
  public String formatDate(Date date) {
    return new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(date);
  }
}
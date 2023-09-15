package javaeetutorials.cdi.alternatives;


import jakarta.enterprise.inject.Alternative;
import java.text.SimpleDateFormat;
import java.util.Date;

@Alternative
public class FormatService implements Formatter {

  @Override
  public String formatDate(Date date) {
    return new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(date);
  }
}
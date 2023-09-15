package javaeetutorials.cdi.qualifierMultiple;

import java.text.SimpleDateFormat;
import java.util.Date;
import javaeetutorials.cdi.qualifierMember.Formatter;

@Custom
@Formatting
public class FormatService implements Formatter {

  @Override
  public String formatDate(Date date) {
    return new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(date);
  }
}
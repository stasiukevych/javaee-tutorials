package javaeetutorials.cdi.qualifierMember;

import java.text.SimpleDateFormat;
import java.util.Date;

@Formatting(format = Format.CUSTOM, isCustom = true)
public class CustomFormatService implements Formatter {

  @Override
  public String formatDate(Date date) {
    return new SimpleDateFormat("MM-dd-yyyy hh:mm:ss").format(date);
  }
}
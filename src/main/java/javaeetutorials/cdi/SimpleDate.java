package javaeetutorials.cdi;

import java.util.Date;

public class SimpleDate implements CurrentDate {

  @Override
  public String printDate() {
    return new Date().toString();
  }
}
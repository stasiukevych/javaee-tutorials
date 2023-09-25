package javaeetutorials.timer;

import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import java.util.Date;

@Stateless
public class StatisticsEJB {

  @Schedule(hour = "*", minute = "*/1")
  public void eachMinuteServerStatistics() {
    System.out.println("Hi buddy, the server alive at: " + new Date());
  }

  @Schedule(hour = "*", minute = "*/5")
  public void eachFileMinuteServerReports() {
    System.out.println("Hi buddy, this report generated on: " + new Date());
  }
}
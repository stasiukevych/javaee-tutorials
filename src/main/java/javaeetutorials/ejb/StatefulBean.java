package javaeetutorials.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateful
public class StatefulBean implements StatefulLocal {

  private static final Logger LOGGER = Logger.getLogger(StatefulBean.class.getName());

  public List<Integer> numbers;

  @PostConstruct
  public void postConstruct() {
    LOGGER.log(Level.INFO, "PostConstruct.");
    numbers = new ArrayList<>();
  }

  @PreDestroy
  public void preDestroy() {
    LOGGER.log(Level.INFO, "PreDestroy.");
    numbers = null;
  }

  @Remove
  public void remove() {
    System.out.println("Remove.");
  }

  @Override
  public void addNumber(Integer number) {
    numbers.add(number);
  }

  @Override
  public void removeNumber(Integer number) {
    numbers.remove(number);
  }

  @Override
  public List<Integer> getNumbers() {
    return numbers;
  }
}
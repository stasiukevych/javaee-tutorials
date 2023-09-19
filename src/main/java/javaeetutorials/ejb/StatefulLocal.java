package javaeetutorials.ejb;

import jakarta.ejb.Local;
import java.util.List;

@Local
public interface StatefulLocal {

  void addNumber(Integer number);

  void removeNumber(Integer number);

  List<Integer> getNumbers();
}

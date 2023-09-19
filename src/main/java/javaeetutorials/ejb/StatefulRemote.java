package javaeetutorials.ejb;

import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface StatefulRemote {

  void addNumber(Integer number);

  void removeNumber(Integer number);

  List<Integer> getNumbers();
}

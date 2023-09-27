package javaeetutorials.autorization;

import jakarta.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class UserService implements Serializable {

  private List<String> userName = new ArrayList<>();

  public void addUserName(String userName) {
    this.userName.add(userName);
  }

  public List<String> findUsers() {
    return userName;
  }

  public String deleteUserName(String userName) {
    this.userName.remove(userName);
    return userName;
  }
}
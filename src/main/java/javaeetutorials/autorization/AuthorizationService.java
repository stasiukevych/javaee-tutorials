package javaeetutorials.autorization;

import jakarta.annotation.security.RolesAllowed;
import jakarta.annotation.security.RunAs;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@RunAs("user")
@RolesAllowed({"user", "admin", "devops"})
public class AuthorizationService {

  private List<String> userName = new ArrayList<>();

  public void addUserName(String userName) {
    this.userName.add(userName);
  }

  public List<String> findUsers() {
    return userName;
  }

  @RolesAllowed("admin")
  public String deleteUserName(String userName) {
    this.userName.remove(userName);
    return userName;
  }
}
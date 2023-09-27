package javaeetutorials.autorization;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
@RolesAllowed({"user", "admin", "devops"})
public class AuthorizationSecurityService {

  @EJB
  private UserService service;

  public void addUserName(String userName) {
    service.addUserName(userName);
  }

  public List<String> findUsers() {
    return service.findUsers();
  }

  @RolesAllowed("admin")
  public String deleteUserName(String userName) {
    service.deleteUserName(userName);
    return userName;
  }
}
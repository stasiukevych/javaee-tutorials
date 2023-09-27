package javaeetutorials.autorization;

import jakarta.annotation.security.RunAs;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RunAs("admin")
@WebServlet(name = "Authorization", urlPatterns = "/users")
public class AuthorizationServlet extends HttpServlet {

  @EJB
  private AuthorizationSecurityService service;

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    ServletOutputStream outputStream = resp.getOutputStream();
    for (String userName : service.findUsers()) {
      outputStream.println(userName);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String userName = request.getParameter("userName");

    service.addUserName(userName);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

    String userName = req.getParameter("userName");

    service.deleteUserName(userName);
  }
}
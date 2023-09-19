package javaeetutorials.ejb;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/stateful")
public class StatefulBeanClient extends HttpServlet {

  @EJB
  private StatefulLocal statefulBean;

  public StatefulBeanClient() {
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    try (PrintWriter out = response.getWriter()) {
      out.println("Adding Number...");
      statefulBean.addNumber(29);
      List<Integer> numbers = statefulBean.getNumbers();
      for (Integer number : numbers) {
        out.println(number);
      }
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Stateful Bean servlet";
  }
}

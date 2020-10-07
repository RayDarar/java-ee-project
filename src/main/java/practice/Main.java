package practice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.entities.User;
import practice.services.EntityService;
import practice.services.UsersService;

@WebServlet("/main")
public class Main extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    List<User> users = UsersService.getUsers();

    req.setAttribute("users", users);
    getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
  }

  @Override
  public void destroy() {
    System.out.println("Closing");
    EntityService.close();
  }
}

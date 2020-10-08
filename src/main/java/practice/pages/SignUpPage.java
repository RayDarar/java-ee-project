package practice.pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import practice.common.ResultMessages;
import practice.entities.User;
import practice.services.UsersService;

@WebServlet("/sign-up")
public class SignUpPage extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String PATH = "/pages/sign-up.jsp";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    getServletContext().getRequestDispatcher(PATH).forward(req, res);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");

    if (username == null || password == null || firstName == null || lastName == null) {
      req.setAttribute("result", "bad-fields");
      getServletContext().getRequestDispatcher(PATH).forward(req, res);
      return;
    }
    User user = new User();
    user.setUsername(username.toLowerCase());
    user.setPassword(password);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    ResultMessages result = UsersService.registerUser(user);

    if (result == ResultMessages.INTERNAL_ERROR) throw new ServletException();

    if (result == ResultMessages.USER_ALREADY_EXISTS) {
      req.setAttribute("result", "user-exists");
      getServletContext().getRequestDispatcher(PATH).forward(req, res);
      return;
    }

    HttpSession session = req.getSession();
    session.setAttribute("username", username.toLowerCase());
    getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
  }
}

package practice.pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.entities.User;
import practice.services.SessionService;
import practice.services.UsersService;

@WebServlet("/sign-in")
public class SignInPage extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String PATH = "/pages/sign-in.jsp";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    getServletContext().getRequestDispatcher(PATH).forward(req, res);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if (username != null) {
      User result = UsersService.findOne(username.toLowerCase());

      if (result != null && result.getPassword().equals(password)) {
        UsersService.setNavUsers(req);
        SessionService.setToken(req, username);
        getServletContext().getRequestDispatcher("/home.jsp").forward(req, res);
        return;
      }
    }

    req.setAttribute("result", false);
    getServletContext().getRequestDispatcher(PATH).forward(req, res);
  }
}

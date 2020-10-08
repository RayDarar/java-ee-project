package practice.pages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    if (username.equals("RayDarar") && password.equals("awdawdawd")) {
      HttpSession session = req.getSession();
      session.setAttribute("username", username);
      getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
      return;
    }

    req.setAttribute("result", false);
    getServletContext().getRequestDispatcher(PATH).forward(req, res);
  }
}

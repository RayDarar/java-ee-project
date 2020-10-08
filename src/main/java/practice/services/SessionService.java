package practice.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionService {
  public static String getToken(HttpServletRequest req) {
    HttpSession session = req.getSession();
    return (String) session.getAttribute("username");
  }

  public static void setToken(HttpServletRequest req, String username) {
    HttpSession session = req.getSession();
    session.setAttribute("username", username.toLowerCase());
  }

  public static void redirectBack(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.sendRedirect(req.getHeader("referer"));
  }
}

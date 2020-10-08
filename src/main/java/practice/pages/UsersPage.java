package practice.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.entities.Post;
import practice.entities.User;
import practice.services.PostsService;
import practice.services.SessionService;
import practice.services.UsersService;

@WebServlet("/users")
public class UsersPage extends HttpServlet {
  private static final long serialVersionUID = 1L;
  

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String guestName = req.getParameter("guest-name");
    if (guestName == null) {
      SessionService.redirectBack(req, res);
      return;
    }

    SessionService.setGuestName(req, guestName);

    String token = SessionService.getToken(req);
    ServletContext context = getServletContext();
    if (token == null) {
      context.getRequestDispatcher("/pages/sign-in.jsp").forward(req, res);
      return;
    }
    User user = UsersService.findOne(guestName);
    List<Post> userPosts = PostsService.getUserPosts(user);

    context.setAttribute("posts", userPosts);

    UsersService.setNavUsers(req);
    context.getRequestDispatcher("/users.jsp").forward(req, res);
  }
}

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

@WebServlet("/home")
public class HomePage extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String token = SessionService.getToken(req);
    ServletContext context = getServletContext();
    if (token == null) {
      context.getRequestDispatcher("/pages/sign-in.jsp").forward(req, res);
      return;
    }
    User user = UsersService.findOne(token);
    List<Post> userPosts = PostsService.getUserPosts(user);

    context.setAttribute("posts", userPosts);

    UsersService.setNavUsers(req);
    context.getRequestDispatcher("/home.jsp").forward(req, res);
  }
}

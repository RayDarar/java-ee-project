package practice.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.entities.User;
import practice.services.PostsService;
import practice.services.SessionService;
import practice.services.UsersService;

@WebServlet("/create-post")
public class CreatePostApi extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String token = SessionService.getToken(req);
    if (token != null) {
      String text = req.getParameter("text");
      User user = UsersService.findOne(token);

      PostsService.createPost(user.getId(), text);
    }

    SessionService.redirectBack(req, res);
  }
}

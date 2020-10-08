package practice.api.comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.entities.User;
import practice.services.CommentsService;
import practice.services.SessionService;
import practice.services.UsersService;

@WebServlet("/create-comment")
public class CreateCommentApi extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String token = SessionService.getToken(req);
    if (token != null) {
      String text = req.getParameter("text");
      int postId = Integer.parseInt(req.getParameter("post-id"));
      User user = UsersService.findOne(token);

      CommentsService.createComment(postId, user.getId(), text);
    }

    SessionService.redirectBack(req, res);
  }
}

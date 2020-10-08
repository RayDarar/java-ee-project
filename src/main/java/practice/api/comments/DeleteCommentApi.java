package practice.api.comments;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.services.CommentsService;
import practice.services.SessionService;

@WebServlet("/delete-comment")
public class DeleteCommentApi extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    int commentId = Integer.parseInt(req.getParameter("comment-id"));
    CommentsService.deleteCommentById(commentId);

    SessionService.redirectBack(req, res);
  }
}

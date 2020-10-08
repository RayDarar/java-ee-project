package practice.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.services.PostsService;

@WebServlet("/delete-post")
public class DeletePostApi extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    int postId = Integer.parseInt(req.getParameter("post-id"));
    PostsService.deletePostById(postId);

    res.sendRedirect(req.getHeader("referer"));
  }
}

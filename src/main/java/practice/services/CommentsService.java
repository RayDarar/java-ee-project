package practice.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import practice.entities.Comment;
import practice.entities.Post;

public class CommentsService {
  public static List<Comment> getPostComments(Post post) {
    try (Connection conn = DatabaseService.getConnection()) {
      String sql = "select * from comments where postId = ?";
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setInt(1, post.getId());

        ResultSet resultSet = statement.executeQuery();
        List<Comment> result = new ArrayList<>();
        while (resultSet.next()) {
          Comment comment = new Comment();
          comment.setId(resultSet.getInt(1));
          comment.setText(resultSet.getString(2));
          comment.setCreationDate(resultSet.getDate(3));
          comment.setPost(post);
          comment.setPostId(post.getId());
          comment.setUser(post.getUser());
          comment.setUserId(post.getUserId());

          result.add(comment);
        }
        return result;
      }
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }
}

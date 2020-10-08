package practice.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import practice.entities.Comment;
import practice.entities.Post;
import practice.entities.User;

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
          // not very optimized
          User user = UsersService.findOne(resultSet.getInt(5));
          comment.setUser(user);
          comment.setUserId(user.getId());

          result.add(comment);
        }
        return result;
      }
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  public static void deleteCommentById(int commentId) {
    try (Connection conn = DatabaseService.getConnection()) {
      String sql = "delete from comments where id = ?";
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setInt(1, commentId);
        statement.executeUpdate();
      }
    } catch (Exception e) {
      return;
    }
  }

  public static void createComment(int postId, int userId, String text) {
    try (Connection conn = DatabaseService.getConnection()) {
      String sql = "insert into comments(text, postId, userId) values(?, ?, ?);";
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, text);
        statement.setInt(2, postId);
        statement.setInt(3, userId);
        statement.executeUpdate();
      }
    } catch (Exception e) {
      return;
    }
  }
}

package practice.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import practice.entities.Post;
import practice.entities.User;

public class PostsService {
  public static List<Post> getUserPosts(User user) {
    try (Connection conn = DatabaseService.getConnection()) {
      String sql = "select * from posts where userId = ?";
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setInt(1, user.getId());

        ResultSet resultSet = statement.executeQuery();
        List<Post> result = new ArrayList<>();
        while (resultSet.next()) {
          Post post = new Post();
          post.setId(resultSet.getInt(1));
          post.setText(resultSet.getString(2));
          post.setCreationDate(resultSet.getDate(3));
          post.setUser(user);
          post.setUserId(user.getId());
          post.setComments(CommentsService.getPostComments(post));

          result.add(post);
        }
        return result;
      }
    } catch (Exception e) {
      return new ArrayList<>();
    }
  }

  public static void deletePostById(int postId) {
    try (Connection conn = DatabaseService.getConnection()) {
      String sql = "delete posts where id = ?";
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setInt(1, postId);
        statement.executeUpdate();
      }
    } catch (Exception e) {
      // bad one, but handling error logs is time consuming for such little project
      return;
    }
  }
}

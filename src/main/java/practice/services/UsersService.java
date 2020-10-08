package practice.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import practice.common.ResultMessages;
import practice.entities.User;

public class UsersService {
  public static ResultMessages registerUser(User userInfo) {
    try (Connection conn = DatabaseService.getConnection()) {
      // saving password in plain text is not a good idea
      // but for the sake of simplicity, let's omit it
      String sql = "insert into users(username, password, firstName, lastName) values(?, ?, ?, ?)";
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, userInfo.getUsername());
        statement.setString(2, userInfo.getPassword());
        statement.setString(3, userInfo.getFirstName());
        statement.setString(4, userInfo.getLastName());

        statement.executeUpdate();
      }
      return ResultMessages.OK;
    } catch (Exception e) {
      if (e instanceof SQLIntegrityConstraintViolationException) {
        return ResultMessages.USER_ALREADY_EXISTS;
      }
      return ResultMessages.INTERNAL_ERROR;
    }
  }

  public static User findOne(String username) {
    try (Connection conn = DatabaseService.getConnection()) {
      String sql = "select * from users where username = ?";
      try (PreparedStatement statement = conn.prepareStatement(sql)) {
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();
        if (!result.next()) return null;

        User user = new User();
        user.setId(result.getInt(1));
        user.setUsername(result.getString(2));
        user.setPassword(result.getString(3));
        user.setFirstName(result.getString(4));
        user.setLastName(result.getString(5));
        return user;
      }
    } catch (Exception e) {
      return null;
    }
  }
}

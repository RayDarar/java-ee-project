package practice.entities;

import java.util.Date;
import java.util.List;

public class Post {
  private int id;
  private String text;
  private Date creationDate;
  private int userId;
  private List<Comment> comments;
  private User user;

  public int getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public User getUser() {
    return user;
  }

  public int getUserId() {
    return userId;
  }

  public void setId(int value) {
    id = value;
  }

  public void setText(String value) {
    text = value;
  }

  public void setCreationDate(Date value) {
    creationDate = value;
  }

  public void setUserId(int value) {
    userId = value;
  }

  public void setComments(List<Comment> value) {
    comments = value;
  }

  public void setUser(User value) {
    user = value;
  }
}

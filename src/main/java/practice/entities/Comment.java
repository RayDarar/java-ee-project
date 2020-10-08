package practice.entities;

import java.util.Date;

public class Comment {
  private int id;
  private String text;
  private Date creationDate;
  private int postId;
  private int userId;
  private Post post;
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

  public int getPostId() {
    return postId;
  }
  public int getUserId() {
    return userId;
  }

  public Post getPost() {
    return post;
  }

  public User getUser() {
    return user;
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

  public void setPostId(int value) {
    postId = value;
  }

  public void setUserId(int value) {
    userId = value;
  }

  public void setPost(Post value) {
    post = value;
  }

  public void setUser(User value) {
    user = value;
  }
}

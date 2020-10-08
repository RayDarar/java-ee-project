package practice.entities;

import java.util.Date;

public class Comment {
  private int id;
  private String text;
  private Date creationDate;
  private int postId;

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
}

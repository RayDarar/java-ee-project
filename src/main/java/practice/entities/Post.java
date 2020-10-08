package practice.entities;

import java.util.Date;

public class Post {
  private int id;
  private String text;
  private Date creationDate;
  private int userId;

  public int getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Date getCreationDate() {
    return creationDate;
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
}

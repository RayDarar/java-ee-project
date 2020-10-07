package practice.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "text")
  private String text;

  @Column(name = "creationDate")
  private Date creationDate;

  @ManyToOne
  @Column(name = "userId")
  private User user;

  @OneToMany
  private List<Comment> comments;

  public int getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public User getUser() {
    return user;
  }

  public List<Comment> getComments() {
    return comments;
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

  public void setUser(User value) {
    user = value;
  }

  public void setComments(List<Comment> value) {
    comments = value;
  }
}

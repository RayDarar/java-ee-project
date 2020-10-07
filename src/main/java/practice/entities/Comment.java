package practice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column(name = "text")
  private String text;

  @Column(name = "creationDate")
  private Date creationDate;

  @ManyToOne
  @Column(name = "postId")
  private Post post;

  public int getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public Post getPost() {
    return post;
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

  public void setPost(Post value) {
    post = value;
  }
}

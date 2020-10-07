package practice.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @OneToMany
  private List<Post> posts;

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setId(int value) {
    id = value;
  }

  public void setUsername(String value) {
    username = value;
  }

  public void setPassword(String value) {
    password = value;
  }

  public void setFirstName(String value) {
    firstName = value;
  }

  public void setLastName(String value) {
    lastName = value;
  }

  public void setPosts(List<Post> value) {
    posts = value;
  }
}

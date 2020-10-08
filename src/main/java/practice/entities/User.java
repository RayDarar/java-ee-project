package practice.entities;

public class User {
  private int id;
  private String username;
  private String password;
  private String firstName;
  private String lastName;

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
}

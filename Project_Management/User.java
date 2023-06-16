package Project_Management;

public class User {
  private String id;
  private String name;
  private String email;
  public User(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
  public String getid() {
    return id;
  }
  public void setid(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}

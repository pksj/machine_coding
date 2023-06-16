package Project_Management;

import java.util.UUID;

public class Card {
  private String id;
  private String name;
  private String Description;
  private User assignedUser;
  
  public Card(String name, String description) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    Description = description;
    this.assignedUser = null;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
  }

  public User getAssignedUser() {
    return assignedUser;
  }

  public void setAssignedUser(User assignedUser) {
    this.assignedUser = assignedUser;
  }
  
  public void unAssignUser() {
    this.assignedUser = null;
  }
}

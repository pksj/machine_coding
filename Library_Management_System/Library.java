package Library_Management_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
  private int id;
  private int numberOfRacks;
  private Map<Integer, User> users;
  private Map<Integer, Map<Integer, BookCopy>> racks;

  public Library(int id, int numberOfRacks) {
    this.id = id;
    this.numberOfRacks = numberOfRacks;
    for (int i = 1; i <= numberOfRacks; i++) {
      this.racks.put(i, new HashMap<>());
    }
    System.out.println("Created library with " + numberOfRacks + " racks");
  }
  
  public void addUser(User user) {
    this.users.put(null, user)
  }
}

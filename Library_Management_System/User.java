package Library_Management_System;

import java.util.List;
import java.util.Map;

public class User {
  private String name;
  private String id;
  private int borrowingCapacity;
  private Map<Integer, Book> booksBorrowed;
  
  public User(String name, String id, int borrowingCapacity) {
    this.name = name;
    this.id = id;
    this.borrowingCapacity = borrowingCapacity;
  }

}

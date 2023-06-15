package Library_Management_System;

import java.util.HashMap;
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
    this.booksBorrowed = new HashMap<>();
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public int getBorrowingCapacity() {
    return borrowingCapacity;
  }

  public Map<Integer, Book> getBooksBorrowed() {
    return booksBorrowed;
  }

  public int getTotalBooksBorrowed() {
    return booksBorrowed.size();
  }

  

}

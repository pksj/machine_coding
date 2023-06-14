package Library_Management_System;

import java.util.List;

public class User {
  String name;
  int id;
  int borrowingCapacity;
  List<Book> booksBorrowed;

  public User(String name, int i, int borrowingCapacity) {
    this.name = name;
    this.id = i;
    this.borrowingCapacity = borrowingCapacity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBorrowingCapacity() {
    return borrowingCapacity;
  }

  public void setBorrowingCapacity(int borrowingCapacity) {
    this.borrowingCapacity = borrowingCapacity;
  }

  public List<Book> getBooksBorrowed() {
    return booksBorrowed;
  }  
}

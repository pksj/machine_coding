package Library_Management_System;

import java.util.List;

/**
 * Rack
 */
public class Rack {
  int id;
  int capacity;
  List<Book> books;
  public Rack(int id, int capacity) {
    this.id = id;
    this.capacity = capacity;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void addBookToRack(Book book){
    this.books.add(book);
  }
}
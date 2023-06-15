package Library_Management_System;

import java.util.List;
import java.util.Map;

/**
 * Rack
 */
public class Rack {
  private int id;
  private int capacity;
  private Map<Integer, Book> books;
  
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

  public boolean addBookToRack(Book book){
    if (this.books.size() == this.capacity) {
      return false;
    }
    if (this.books.get(book.getId()) != null) {
      return false;
    }
    this.books.put(book.getId(), book);
    return true;
  }
}
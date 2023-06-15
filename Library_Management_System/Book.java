package Library_Management_System;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {
  private int id;
  private String title;
  private List<String> authors;
  private List<String> publishers;
  
  public Book(int id, String title, List<String> authors, List<String> publishers) {
    this.id = id;
    this.title = title;
    this.authors = authors;
    this.publishers = publishers;
  }
  public int getId() {
    return id;
  }
  public String getTitle() {
    return title;
  }
  public List<String> getAuthors() {
    return authors;
  }
  public List<String> getPublishers() {
    return publishers;
  }
}

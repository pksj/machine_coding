package Library_Management_System;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {
  private String id;
  private String bookCopyId;
  private String title;
  private User borrowedBy;
  private String dueDate;
  private Rack rack;
  private List<String> authors;
  private List<String> publishers;
  
  public Book(String id, String bookCopyId, String title, List<String> authors, List<String> publishers) {
    this.id = id;
    this.bookCopyId = bookCopyId;
    this.title = title;
    this.authors = authors;
    this.publishers = publishers;
  }
  public String getId() {
    return id;
  }
  public String getBookCopyId() {
    return bookCopyId;
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
  public User getBorrowedBy() {
    return borrowedBy;
  }
  public String getDueDate() {
    return dueDate;
  }
  public Rack getRack() {
    return rack;
  }
  public void setBorrowedBy(User borrowedBy) {
    this.borrowedBy = borrowedBy;
  }
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public void setRack(Rack rack) {
    this.rack = rack;
  }

  public boolean isBorrowed() {
    return this.borrowedBy != null;
  }
}

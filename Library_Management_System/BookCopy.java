package Library_Management_System;

public class BookCopy {
  private String id;
  private Book book;
  private User borrowedBy;
  private String dueDate;
  private Rack rack;
  public BookCopy(String id, Book book) {
    this.id = id;
    this.book = book;
  }
  public String getId() {
    return id;
  }
  public Book getBook() {
    return book;
  }
  public User getBorrowedBy() {
    return borrowedBy;
  }
  public String getDueDate() {
    return dueDate;
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
}

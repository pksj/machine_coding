package Library_Management_System;

public class Book {
  int id;
  String title;
  String authors;
  String publishers;
  public Book(int id, String title, String authors, String publishers) {
    this.id = id;
    this.title = title;
    this.authors = authors;
    this.publishers = publishers;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getAuthors() {
    return authors;
  }
  public void setAuthors(String authors) {
    this.authors = authors;
  }
  public String getPublishers() {
    return publishers;
  }
  public void setPublishers(String publishers) {
    this.publishers = publishers;
  }
}

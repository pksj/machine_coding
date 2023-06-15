package Library_Management_System;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {
  private String id;
  private int numberOfRacks;
  private int booksPerRack = 5;
  private Map<String, User> users;
  private Map<String, Map<String, Book>> racks;

  public Library(String id, int numberOfRacks) {
    this.id = id;
    this.numberOfRacks = numberOfRacks;
    this.users = new HashMap<>();
    this.racks = new HashMap<>();
    for (int i = 1; i <= numberOfRacks; i++) {
      this.racks.put(Integer.toString(i), new HashMap<>());
    }
    System.out.println("Created library with " + numberOfRacks + " racks");
  }

  public void addUser(User user) {
    this.users.put(user.getId(), user);
    System.out.println("user " + user.getId() + " added successfully.");
  }

  public String addBook(Book book) {
    String rackId = null;
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      rackId = rack.getKey();
      Map<String, Book> booksOnRack = rack.getValue();
      if (booksOnRack.get(book.getId()) == null) {
        booksOnRack.put(book.getId(), book);
        break;
      }
    }
    return rackId;
  }

  public void removeBookCopy(String bookCopyId) {
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      String rackId = rack.getKey();
      Map<String, Book> booksOnRack = rack.getValue();
      for (Map.Entry<String, Book> book : booksOnRack.entrySet()) {
        if (book.getValue().getBookCopyId().equals(bookCopyId)) {
          booksOnRack.remove(book.getKey());
          System.out.println("Removed book copy: " + bookCopyId + " from rack: " + rackId);
          return;
        }
      }
    }
    System.out.println("Invalid Book Copy ID");
  }

  public int getTotalAvailableRacks() {
    int count = 0;
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      count += (this.booksPerRack - rack.getValue().size()) > 0 ? 1 : 0;
    }
    return count;
  }

  public void borrowBookByBookId(String bookId, User user, String dueDate) {
    boolean bookAvailable = false;
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      String rackId = rack.getKey();
      Map<String, Book> booksOnRack = rack.getValue();
      for (Map.Entry<String, Book> book : booksOnRack.entrySet()) {
        if (book.getValue().getId().equals(bookId)) {
          bookAvailable = true;
          if (book.getValue().getBorrowedBy() == null) {
            book.getValue().setBorrowedBy(user);
            book.getValue().setDueDate(dueDate);
            System.out.println("Borrowed book copy from rack: " + rackId);
            return;
          }
        }
      }
    }
    if (bookAvailable == true) {
      System.out.println("Not Available.");
    } else {
      System.out.println("Invalid Book Copy ID.");
    }
  }

  public void borrowBookByBookCopyId(String bookCopyId, User user, String dueDate) {
    boolean bookAvailable = false;
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      String rackId = rack.getKey();
      Map<String, Book> booksOnRack = rack.getValue();
      for (Map.Entry<String, Book> book : booksOnRack.entrySet()) {
        if (book.getValue().getBookCopyId().equals(bookCopyId)) {
          bookAvailable = true;
          if (book.getValue().getBorrowedBy() == null) {
            book.getValue().setBorrowedBy(user);
            book.getValue().setDueDate(dueDate);
            System.out.println("Borrowed book copy from rack: " + rackId);
            return;
          }
        }
      }
    }
    if (bookAvailable == true) {
      System.out.println("Not Available.");
    } else {
      System.out.println("Invalid Book Copy ID.");
    }
  }

  public User getUserByUserId(String userId) {
    return users.get(userId);
  }

  public void returnBook(String bookCopyId) {
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      String rackId = rack.getKey();
      Map<String, Book> booksOnRack = rack.getValue();
      for (Map.Entry<String, Book> book : booksOnRack.entrySet()) {
        if (book.getValue().getBookCopyId().equals(bookCopyId)) {
          book.getValue().setBorrowedBy(null);
          book.getValue().setDueDate(null);
          System.out.println("Returned book copy" + bookCopyId + " and added to rack:" + rackId);
          return;
        }
      }
    }
    System.out.println("Invalid Book Copy ID");
  }

  public void printBorrowed(String userId) {
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      Map<String, Book> booksOnRack = rack.getValue();
      for (Map.Entry<String, Book> book : booksOnRack.entrySet()) {
        User borrower = book.getValue().getBorrowedBy();
        if (borrower != null && borrower.getId().equals(userId)) {
          System.out.println("Book Copy: " + book.getValue().getBookCopyId() + " " + book.getValue().getDueDate());
        }
      }
    }
  }

  public void search(String attribute, String attributeValue) {
    for (Map.Entry<String, Map<String, Book>> rack : racks.entrySet()) {
      Map<String, Book> booksOnRack = rack.getValue();
      for (Map.Entry<String, Book> entry : booksOnRack.entrySet()) {
        Book book = entry.getValue();
        User borrower = book.getBorrowedBy();
        boolean bookFound = false;
        switch (attribute) {
          case "book_id":
            bookFound = book.getId().equals(attributeValue);
            break;
          case "book_copy_id":
            bookFound = book.getBookCopyId().equals(attributeValue);
            break;
          case "title":
            bookFound = book.getTitle().equals(attributeValue);
            break;
          case "author_id":
            bookFound = book.getAuthors().contains(attributeValue);
            break;
          case "publisher":
            bookFound = book.getPublishers().contains(attributeValue);
            break;
          default:
            break;
        }
        if (bookFound) {
          System.out.print("Book Copy: " + book.getBookCopyId() + " " + book.getId() + " " + book.getTitle() + " "
              + String.join(",", book.getAuthors()) + " " + String.join(",", book.getPublishers()) + " "+ (borrower != null ? rack.getKey() : "-1"));
          System.out.println(borrower != null ? (borrower.getId() + " " + book.getDueDate()) : "");
        }
      }
    }
  }
}

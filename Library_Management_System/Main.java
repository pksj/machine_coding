package Library_Management_System;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String commands = """
        -----------------------------------------------------------------------------------
        1:create_library <library_id> <no_of_racks>
        2:add_book <book_id> <title> <comma_separated_authors>
          <comma_separated_publishers> <comma_separated_book_copy_ids>
        3:remove_book_copy <book_copy_id>
        4:borrow_book <book_id> <user_id> <due_date>
        5:borrow_book_copy <book_copy_id> <user_id> <due_date>
        6:return_book_copy <book_copy_id>
        7:print_borrowed <user_id>
        8:search <attribute> <attribute_value>
          Possible values of attribute: book_id, author, publisher
        9:exit
        -----------------------------------------------------------------------------------
            """;
    System.out.println(commands);
    Scanner sc = new Scanner(System.in);
    Library library = null;
    boolean flag = true;
    while (flag) {
      // String[] inputs = sc.nextLine().split(" ");
      String[] instructions = new String[] {
          "create_library library1 10",
          "add_user pawan user1 5",
          "add_book 1 book1 author1,author2 publisher1 book_copy1,book_copy2,book_copy3",
          "add_book 2 book2 author2,author3 publisher2,publisher3 book_copy4,book_copy5,book_copy6,book_copy7,book_copy8,book_copy9,book_copy10",
          "add_book 3 book3 author2 publisher2 book_copy11,book_copy12,book_copy13",
          "search book_id 1",
          "search book_id 3",
          "search author_id author2",
          "search author_id author3",
          "remove_book_copy book_copy6",
          "remove_book_copy book_copy13",
          "add_book 3 book3 author2 publisher2 book_copy13",
          "search book_id 2",
          "print_borrowed user1",
          "borrow_book 1 user1 2020-12-31",
          "borrow_book 1 user1 2020-12-31",
          "borrow_book 1 user1 2020-12-31",
          "borrow_book 1 user1 2020-12-31",
          "search book_id 1",
          "search author_id author1",
          "borrow_book 4 user1 2020-12-31",
          "borrow_book 2 user1 2020-12-31",
          "borrow_book 2 user1 2020-12-31",
          "borrow_book 2 user1 2020-12-31",
          "print_borrowed user1",
          "return_book_copy book_copy1",
          "return_book_copy book_copy2",
          "borrow_book_copy book_copy1 user1 2020-11-31",
          "borrow_book_copy book_copy2 user1 2020-11-31",
          "borrow_book_copy book_copy10 user1 2020-11-31",
          "print_borrowed user1",
          "exit"
      };
      for (int i = 0; i < instructions.length; i++) {
        String[] inputs = instructions[i].split(" ");
        switch (inputs[0]) {
          case "create_library":
            library = new Library(inputs[1], Integer.parseInt(inputs[2]));
            break;
          case "add_user":
            User user = new User(inputs[1], inputs[2], Integer.parseInt(inputs[3]));
            library.addUser(user);
            break;
          case "add_book":
            String[] bookCopyIds = inputs[5].split(",");
            if (library.getTotalAvailableRacks() < bookCopyIds.length) {
              System.out.println("Rack not available");
            } else {
              List<String> racksUsed = new ArrayList<>();
              for (String bookCopyId : bookCopyIds) {
                Book book = new Book(inputs[1], bookCopyId, inputs[2],
                    new ArrayList<>(Arrays.asList(inputs[3].split(","))),
                    new ArrayList<>(Arrays.asList(inputs[4].split(","))));
                String rackId = library.addBook(book);
                racksUsed.add(rackId);
              }
              System.out.println("Added Books to racks: " + String.join(",", racksUsed));
            }
            break;
          case "remove_book_copy":
            library.removeBookCopy(inputs[1]);
            break;
          case "borrow_book":
          case "borrow_book_copy":
            user = library.getUserByUserId(inputs[2]);
            if (user == null) {
              System.out.println("Invalid user.");
            } else {
              int booksBorrowedByUser = user.getTotalBooksBorrowed();
              if (booksBorrowedByUser > user.getBorrowingCapacity()) {
                System.out.println("OverLimit.");
              } else {
                String dueDate = inputs[3];
                if (inputs[0].equals("borrow_book")) {
                  String bookId = inputs[1];
                  library.borrowBookByBookId(bookId, user, dueDate);
                } else {
                  String bookCopyId = inputs[1];
                  library.borrowBookByBookCopyId(bookCopyId, user, dueDate);
                }

              }
            }
            break;
          case "return_book_copy":
            String bookCopyId = inputs[1];
            library.returnBook(bookCopyId);
            ;
            break;
          case "print_borrowed":
            String userId = inputs[1];
            library.printBorrowed(userId);
            break;
          case "search":
            String attribute = inputs[1];
            String attributeValue = inputs[2];
            library.search(attribute, attributeValue);
            break;
          case "exit":
          default:
            flag = false;
            break;

        }
        System.out.println("----------------------------------------------------------------------");
      }

    }
    sc.close();
  }
}

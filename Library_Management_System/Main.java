package Library_Management_System;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String commands = """
      1:create_library <library_id> <no_of_racks> 
      2:add_book <book_id> <title> <comma_separated_authors> <comma_separated_publishers> <comma_separated_book_copy_ids>
      3:remove_book_copy <book_copy_id>
      4:borrow_book <book_id> <user_id> <due_date>
      5:borrow_book_copy <book_copy_id> <user_id> <due_date>
      6:return_book_copy <book_copy_id>
      7:print_borrowed <user_id>
      8:search <attribute> <attribute_value>
        Possible values of attribute: book_id, author, publisher
      9:exit
          """;
    System.out.println(commands);
    // Scanner sc = new Scanner(System.in);

    // Library library = null;

    // do {
    //   String
    // } while (library == null);
    // for(int i = 1; i <= 5; i++){
    //   library.addUser(new User("user"+i,i,5));
    // }
    // for (int i = 1; i <= 5; i++) {
    //   Rack rack = new Rack(i, 5);
    //   for (int j = 1; j <= 5; j++) {
    //     rack.addBookToRack(new Book(j, "title" + 1, "authors" + i, "publishers" + i));
    //   }
    //   library.addRack(rack);
    // }
  }
}

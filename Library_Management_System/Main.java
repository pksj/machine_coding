package Library_Management_System;
import java.util.ArrayList;
import java.util.Arrays;
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
    String[] inputs = sc.nextLine().split(" ");
    
    switch (inputs[1]) {
      case "create_library":
        library = new Library(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));
        for(int i = 1; i <= 5; i++){
          library.addUser(new User("user"+i,i,5));
        }
        for (int i = 1; i <= library.getNumberOfRacks(); i++) {
          Rack rack = new Rack(i, 5); // 5 books per rack
          library.addRack(rack);
        }
        break;
      case "add_book":
        Book book = new Book(Integer.parseInt(inputs[1]), inputs[2],
            new ArrayList<>(Arrays.asList(inputs[3].split(","))), new ArrayList<>(Arrays.asList(inputs[4].split(","))));
        
        String[] bookCopies = inputs[5].split(",");
        for (String bookCopy : bookCopies) {
          
        }   
        break;
      default:
        break;
    }
  }
}

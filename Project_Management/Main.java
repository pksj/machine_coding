package Project_Management;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Map<String, Board> boards = new HashMap<>();
    Map<String, User> users = new HashMap<>();
    users.put("user1", new User("user1", "pawan", "pawan@gmail.com"));
    users.put("user2", new User("user2", "kumar", "kumar@gmail.com"));
    users.put("user3", new User("user3", "jawale", "jawale@gmail.com"));
    Scanner sc = new Scanner(System.in);
    while (true) {
      String[] inputs = sc.nextLine().split(" ");

      switch (inputs[0]) {
        case "Board":
          switch (inputs[1]) {
            case "CREATE":

              break;
            case "ADD_MEMBER":

              break;
            case "REMOVE_MEMBER":

              break;
            case "DELETE":

              break;

            default:
              break;
          }

          break;
        case "List":
          switch (inputs[1]) {
            case "CREATE":

              break;
            case "DELETE":

              break;

            default:
              break;
          }
          break;
        case "CARD":

          break;
        case "SHOW":

        default:
          break;
      }
    }

  }
}

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
              String boardName = inputs[2];
              Board board = new Board(boardName);
              boards.put(board.getId(), board);
              break;
            case "ADD_MEMBER":
              String boardId = inputs[2];
              String userId = inputs[3];
              boards.get(boardId).addMember(users.get(userId));
              break;
            case "REMOVE_MEMBER":
              boardId = inputs[2];
              userId = inputs[3];
              boards.get(boardId).removeMember(users.get(userId));
              break;
            case "DELETE":
              boardId = inputs[2];
              boards.remove(boardId);
              break;
            default:
              break;
          }
          break;
        case "List":
          switch (inputs[1]) {
            case "CREATE":
            String listName = inputs[2];
            String boardId = inputs[3];
            List list = new List(listName);
            boards.get(boardId).addList(list);
              break;
            case "DELETE":
              String boardId = inputs[2];
              String listId = inputs[3];
              boards.get(boardId).getLists().get(listId).removeList(list);
              break;

            default:
              break;
          }
          break;
        case "CARD":
          switch (inputs[1]) {
            case "CREATE":

              Card card = new Card(null, null); 
              break;
            case "ASSIGN":

              break;
            case "UNASSIGN":

              break;
            case "MOVE":

              break;

            case "DELETE":

              break;

            default:
              break;
          }
          break;
        case "SHOW":
          switch (inputs[1]) {
            case "BOARD":

              break;
            case "LIST":

              break;
            case "CARD":

              break;

            default:
              break;
          }
          break;
        default:
          break;
      }
    }

  }
}

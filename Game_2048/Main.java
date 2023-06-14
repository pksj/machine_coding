
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int boardSize = 0;
      do {
        System.out.println("Please enter board size. It must be integer greater than 3.");
        boardSize = sc.nextInt();
      } while (boardSize < 4);
      int winningScore = 0;
      do {
        System.out.println("Enter winning score. It should be power of 2 and greater than 2. Suggested is 2048.");
        winningScore = sc.nextInt();
      } while (winningScore <= 2 || (winningScore & (winningScore - 1)) != 0);
      
      Board board = new Board(boardSize, winningScore);
      board.print();
      while (true) {
        System.out.println("Input direction => left:0, right:1, up:2, down:3");
        int moveDirection = sc.nextInt();
        switch (moveDirection) {
          case 0:
            board.moveLeft();
            break;
          case 1:
            board.moveRight();
            break;
          case 2:
            board.moveUp();
            break;
          case 3:
            board.moveDown();
            break;
          default:
            System.out.println("Invalid direction");
            continue;
        }

        if (board.checkForWin() == true) {
          board.print();
          System.out.println("Congratulation! You won");
          break;
        }
        if (board.checkForGameOver() == true) {
          System.out.println("Game over");
          break;
        }
        board.addTile();
        board.print();
      }

      System.out.println("Want to replay? reply with yes or no.");
      String userResponse = sc.nextLine();
      System.out.println(userResponse);
      if (userResponse.equals("yes")) {
        continue;
      } else {
        break;
      }
    }
    sc.close();
  }
}

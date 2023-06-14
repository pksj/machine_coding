
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Board board = new Board(5);
    board.print();
    Scanner sc = new Scanner(System.in);
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
        System.out.println("Congratulation");
        break;
      }
      if (board.checkForGameOver() == true) {
        System.out.println("Game over");
        break;
      }
      board.addTile();
      board.print();
    }
    sc.close();
  }
}

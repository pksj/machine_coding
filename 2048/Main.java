import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Board board = new Board(4);
    board.print();
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Input direction: 0 : left, 1 : right, 2 : up: 3 : down");
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

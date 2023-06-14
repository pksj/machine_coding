/**
 * Board
 */
public class Board {
  int n;
  int[][] board;

  Board(int n) {
    this.n = n;
    board = new int[n][n];
    addTile();
    addTile();
  }

  void moveRight() {
    for (int i = 0; i < n; i++) {
      int sum = getSumAndClearRow(i);
      board[i][n - 1] = sum;
    }
  }
  
  void moveLeft() {
    for (int i = 0; i < n; i++) {
      int sum = getSumAndClearRow(i);
      board[i][0] = sum;
    }
  }
  
  void moveUp() {
    for (int i = 0; i < n; i++) {
      int sum = getSumAndClearColumn(i);
      board[0][i] = sum;
    }
  }
  
  void moveDown() {
    for (int i = 0; i < n; i++) {
      int sum = getSumAndClearColumn(i);
      board[n-1][i] = sum;
    }
  }
  
  boolean checkForWin() {
    for (int[] row : board) {
      for (int cell : row) {
        if (cell == 2048) {
          return true;
        }
      }
    }
    return false;
  }
  
  boolean checkForGameOver() {
    for (int[] row : board) {
      for (int cell : row) {
        if (cell == 0) {
          return false;
        }
      }
    }
    return true;
  }

  void print() {
    for (int[] row : board) {
      for (int cell : row) {
        System.out.print((cell == 0 ? "-" : cell) + " ");
      }
      System.out.println("");
    }
  }

  int getSumAndClearRow(int row) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += board[row][i];
      board[row][i] = 0;
    }
    return sum;
  }
  
  int getSumAndClearColumn(int col) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += board[i][col];
      board[i][col] = 0;
    }
    return sum;
  }
  
  void addTile() {
    while (true) {
      int row = (int)(Math.random()*n);
      int col = (int) (Math.random() * n);
      if (board[row][col] == 0) {
        board[row][col] = 2;
        break;
      } else {
        continue;
      }
    }
  }
}
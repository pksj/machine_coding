public class Board {
  int n;
  int winningScore;
  int[][] board;

  Board(int n, int winningScore) {
    this.n = n;
    this.winningScore = winningScore;
    board = new int[n][n];
    addTile();
    addTile();
  }

  void moveRight() {
    for (int i = 0; i < n; i++) {
      moveRowRight(i);
      for (int j = n - 1; j > 0; j--) {
        if (board[i][j - 1] == board[i][j]) {
          board[i][j] *= 2;
          board[i][j - 1] = 0;
        }
      }
      moveRowRight(i);
    }
  }

  void moveLeft() {
    for (int i = 0; i < n; i++) {
      moveRowLeft(i);
      for (int j = 0; j < n-1; j++) {
        if (board[i][j + 1] == board[i][j]) {
          board[i][j] *= 2;
          board[i][j + 1] = 0;
        }
      }
      moveRowLeft(i);
    }
  }

  void moveUp() {
    for (int i = 0; i < n; i++) {
      moveColumnUp(i);
      for (int j = 0; j < n-1; j++) {
        if (board[i][j + 1] == board[i][j]) {
          board[i][j] *= 2;
          board[i][j + 1] = 0;
        }
      }
      moveColumnUp(i);
    }
  }

  void moveDown() {
    for (int i = 0; i < n; i++) {
      moveColumnDown(i);
      for (int j = n-2; j >= 0; j--) {
        if (board[i][j+1] == board[i][j]) {
          board[i][j+1] *= 2;
          board[i][j] = 0;
        }
      }
      moveColumnDown(i);
    }
  }

  void moveRowRight(int row) {
    int lastIndex = n - 1;
    for (int j = n - 1; j >= 0; j--) {
      if (board[row][j] != 0) {
        board[row][lastIndex] = board[row][j];
        lastIndex--;
      }
    }
    while (lastIndex >= 0) {
      board[row][lastIndex--] = 0;
    }
  }

  void moveRowLeft(int row) {
    int lastIndex = 0;
    for (int j = 0; j < n; j++) {
      if (board[row][j] != 0) {
        board[row][lastIndex] = board[row][j];
        lastIndex++;
      }
    }
    while (lastIndex < n) {
      board[row][lastIndex++] = 0;
    }
  }

  void moveColumnDown(int col) {
    int lastIndex = n - 1;
    for (int j = 0; j < n; j++) {
      if (board[j][col] != 0) {
        board[lastIndex][col] = board[j][col];
        lastIndex--;
      }
    }
    while (lastIndex >= 0) {
      board[lastIndex--][col] = 0;
    }
  }

  void moveColumnUp(int col) {
    int lastIndex = 0;
    for (int j = 0; j < n; j++) {
      if (board[j][col] != 0) {
        board[lastIndex][col] = board[j][col];
        lastIndex++;
      }
    }
    while (lastIndex < n) {
      board[lastIndex++][col] = 0;
    }
  }

  boolean checkForWin() {
    for (int[] row : board) {
      for (int cell : row) {
        if (cell == this.winningScore) {
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

  void addTile() {
    while (true) {
      int row = (int) (Math.random() * n);
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
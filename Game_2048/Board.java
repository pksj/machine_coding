
public class Board {
  int n;
  int[][] board;

  Board() {
    this.n = 4;
    board = new int[n][n];
    addTile();
    addTile();
  }

  void moveRight() {
    for (int i = 0; i < n; i++) {
      boolean merged = false;
      if (board[i][0] == board[i][1]) {
        board[i][1] *= 2;
        board[i][0] = 0;
        merged = true;
      }

      if (board[i][2] == board[i][3]) {
        board[i][3] *= 2;
        board[i][2] = 0;
        merged = true;
      }
      
      if (merged == false && board[i][1] == board[i][2]) {
        board[i][2] *= 2;
        board[i][1] = 0;
        merged = true;
      }

      if (merged == true) {
        int lastIndex = n - 1;
        for (int j = n - 1; j >= 0; j--) {
          if (board[i][j] != 0) {
            board[i][lastIndex] = board[i][j];
            lastIndex--;
          }
        }
        while (lastIndex >= 0) {
          board[i][lastIndex--] = 0;
        }
      }
      
    }
  }
  
  void moveLeft() {
    for (int i = 0; i < n; i++) {
      boolean merged = false;
      if (board[i][0] == board[i][1]) {
        board[i][0] *= 2;
        board[i][1] = 0;
        merged = true;
      }

      if (board[i][2] == board[i][3]) {
        board[i][2] *= 2;
        board[i][3] = 0;
        merged = true;
      }
      
      if (merged == false && board[i][1] == board[i][2]) {
        board[i][1] *= 2;
        board[i][2] = 0;
        merged = true;
      }

      if (merged == true) {
        int lastIndex = 0;
        for (int j = 0; j < n; j++) {
          if (board[i][j] != 0) {
            board[i][lastIndex] = board[i][j];
            lastIndex++;
          }
        }
        while (lastIndex < n) {
          board[i][lastIndex++] = 0;
        }
      }
    }
  }
  
  void moveUp() {
     for (int i = 0; i < n; i++) {
      boolean merged = false;
      if (board[0][1] == board[1][i]) {
        board[0][i] *= 2;
        board[1][i] = 0;
        merged = true;
      }

      if (board[2][i] == board[3][i]) {
        board[2][i] *= 2;
        board[3][i] = 0;
        merged = true;
      }
      
      if (merged == false && board[1][i] == board[2][i]) {
        board[1][i] *= 2;
        board[2][i] = 0;
        merged = true;
      }

      if (merged == true) {
        int lastIndex = 0;
        for (int j = 0; j < n; j++) {
          if (board[j][i] != 0) {
            board[lastIndex][i] = board[j][i];
            lastIndex++;
          }
        }
        while (lastIndex < n) {
          board[lastIndex++][i] = 0;
        }
      } 
    }
  }
  
  void moveDown() {
    // here i is column
     for (int i = 0; i < n; i++) {
      boolean merged = false;
      if (board[0][1] == board[1][i]) {
        board[1][i] *= 2;
        board[0][i] = 0;
        merged = true;
      }

      if (board[2][i] == board[3][i]) {
        board[3][i] *= 2;
        board[2][i] = 0;
        merged = true;
      }
      
      if (merged == false && board[1][i] == board[2][i]) {
        board[2][i] *= 2;
        board[1][i] = 0;
        merged = true;
      }

      if (merged == true) {
        int lastIndex = n - 1;
        for (int j = n - 1; j >= 0; j--) {
          if (board[j][i] != 0) {
            board[lastIndex][i] = board[j][i];
            lastIndex--;
          }
        }
        while (lastIndex >= 0) {
          board[lastIndex--][i] = 0;
        }
      }
      
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

  // int getSumAndClearRow(int row) {
  //   int sum = 0;
  //   for (int i = 0; i < n; i++) {
  //     sum += board[row][i];
  //     board[row][i] = 0;
  //   }
  //   return sum;
  // }
  
  // int getSumAndClearColumn(int col) {
  //   int sum = 0;
  //   for (int i = 0; i < n; i++) {
  //     sum += board[i][col];
  //     board[i][col] = 0;
  //   }
  //   return sum;
  // }
  
  void addTile() {
    while (true) {
      int row = (int)(Math.random()*n);
      int col = (int) (Math.random()*n);
      if (board[row][col] == 0) {
        board[row][col] = 2;
        break;
      } else {
        continue;
      }
    }
  }
}
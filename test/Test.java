package test;

import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    int[][] grid = new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
    int n = grid.length;
    String[] rows = new String[n];
    String[] cols = new String[n];
    for (int i = 0; i < n; i++) {
      int[] row = new int[n];
      int[] col = new int[n];
      for (int j = 0; j < n; j++) {
        row[j] = grid[i][j];
        col[j] = grid[j][i];
      }
      rows[i] = Arrays.toString(row);
      cols[i] = Arrays.toString(col);
      System.out.println(row.toString() + col.toString());
    }
    int pairs = 0;
    for (String row : rows) {
      for (String col : cols) {
        if (col.equals(row)) {
          pairs++;
        }
      }
    }
    System.out.println(pairs);
  }
}

import java.util.*;

public class matrix {

  public static void main(String[] args) {
    int r,c,sumRow,sumCol;
    int a[][] = {{1,2,3},{4,5,6},{7,8,9}};
    int rows = a.length;
    int columns = a[0].length;
    for (int i = 0; i < rows; i++) {
      sumRow = 0;
      for (int j = 0; j < columns; j++ ) {
          sumRow += a[i][j];
      }
      System.out.println("Sum of "+(i+1)+" row: "+sumRow);
    }
    for(int i = 0; i < columns; i++){
      sumCol = 0;
      for(int j = 0; j < rows; j++){
        sumCol += a[j][i];
      }
      System.out.println("Sum of " + (i+1) +" column: " + sumCol);
    }
  }

}

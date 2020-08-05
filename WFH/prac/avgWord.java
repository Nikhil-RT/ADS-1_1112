import java.util.*;

public class avgWord {
  private double Sol(String sentence) {
    double sum = 0;
    double avg = 0;
    int count = 0;
    String delim = "!.?;:',";
    for (int i = 0;i <sentence.length();i++) {
      double charNum = sentence.length();
      sum = charNum + sum;
      count++;

      if (count > 0) {
        avg = sum/count;
        // System.out.print(avg);
      }
    }
      System.out.print("average word len : " + avg);
    return 0.0;
  }
  public static void main(String[] args) {
    avgWord obj = new avgWord();
    obj.Sol("this is a test");
  }
}

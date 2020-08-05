import java.util.*;

public class reverseInteger {

  public String revStr(String a) {
    // System.out.println("1");
    int n = a.length();
    String rev ="";
    if (a.charAt(0) == '-') {
      for (int i = a.length()-1; i >= 0; i--) {
        rev += a.charAt(i);
      }
      System.out.println("-"+rev.substring(0,n-1));
    }
    else {
      System.out.println();
      for (int i = a.length()-1; i >= 0; i--) {
        rev += a.charAt(i);
      }
      System.out.print(rev.substring(0,n));
    }
    return "Not possible";
  }

  public static void main(String[] args) {
    reverseInteger obj = new reverseInteger();
    obj.revStr("-987");
    obj.revStr("123");
  }

}

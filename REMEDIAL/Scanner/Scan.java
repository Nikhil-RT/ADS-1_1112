import java.util.*;

import org.omg.CORBA.INTERNAL;

class Scan {
    /**
     * 
     * next() = string - Up to first space
     * nextLine() = String - It will read whole Line
     * nextInt() = integer
     * nextDouble() = Double
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        int in1 = scan.nextInt();
        int in2 = scan.nextInt();
        double in3 = scan.nextDouble();
        String in4 = scan.next();
        System.out.println(in);
        System.out.println(in1);
        System.out.println(in2);
        System.out.println(in3);
        System.out.println(in4);
        scan.close();
    }
}
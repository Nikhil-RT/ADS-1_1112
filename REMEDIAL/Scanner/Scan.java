import java.lang.reflect.Array;
import java.util.*;

import org.omg.CORBA.INTERNAL;

class Student {
    String name;
    int maths;
    int science;
    int social;
    
    public Student(String name, int maths, int science, int social) {
        this.name = name;
        this.maths = maths;
        this.science = science;
        this.social = social;
    }

    public String toString() {
        return this.name +" "+this.maths +" "+ this.science +" "+ this.social;
    }

}

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
        System.out.println("Enter no.of lines : ");
        String noofLines = scan.nextLine();
        int n = Integer.parseInt(noofLines);
        // String[] StudentArr = new String[n];
        Student[] arr = new Student[n];

        for (int i = 0; i < n;  i++) {
            String name = scan.next();
            int maths = scan.nextInt();
            int science = scan.nextInt();
            int social = scan.nextInt();
            // String s = scan.nextLine();
            Student a = new Student(name, maths, science, social);
            arr[i] = a;
            // System.out.println(arr[i]);
        }
        System.out.println("=========THE OUTPUT=========");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(Arrays.toString(arr));
        scan.close();
    }
}
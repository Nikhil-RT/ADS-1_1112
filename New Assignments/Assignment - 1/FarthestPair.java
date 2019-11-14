import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Write a program that, given an array a[] of N double values, 
 * finds a farthest pair : 
 * two values whose difference is no smaller than the difference
 * between any other pair. 
 * The running time of your program should be linear in the worst case.
 * @author Nikhil Ravi Teja
 */
class FarthestPair{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter No. of values: ");
        int number = scan.nextInt();
        // We do try & catch operations for errors
        do{
        try{    
        if(number < 0) {
            throw new InputMismatchException();
        }
        }
        catch(InputMismatchException exception) {
            System.out.println("Enter the Input again");
            //Again call for input
            number = scan.nextInt();
        }
        }while(false);
        double[] a = new double[number];
        
        // Let's take an Double Array
        // double a[] = {5.0, 7.0, 2.0, 4.0, 3.0}; 
        int i = 0;
        //Iterating input using for loop
        for (int j = 0; j < a.length; j++) {
            a[j] = scan.nextDouble();
        }
        double Min = a[0];
        double Max = a[0];
        //Iterating using While loop
        while (i < a.length) { 
            //Finding Min
            if(a[i] < Min) {
               Min = a[i];
               System.out.println(a[i]);
            }
            //Finding Max
            if (a[i] > Max) {
               Max = a[i];
            }
            i++;
        }
        scan.close();
        //Printing Min and Max in a pair
        System.out.println("(" + Min + "," + Max + ")");
        // System.out.println();

    }
}
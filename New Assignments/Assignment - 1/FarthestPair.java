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
        // Let's take an Double Array
        double a[] = {5.0, 7.0, 2.0, 4.0, 3.0}; 
        int i = 0;
        double Min = a[0];
        double Max = a[0];
        //Iterating using While loop
        while (i < a.length) { 
            //Finding Min
            if(a[i] < Min) {
               Min = a[i];
            }
            //Finding Max
            if (a[i] > Max) {
               Max = a[i];
            }
            i++;
        }
        //Printing Min and Max in a pair
        System.out.println("(" + Min + "," + Max + ")");

    }
}